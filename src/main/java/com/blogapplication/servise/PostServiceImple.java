package com.blogapplication.servise;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blogapplication.entity.Category;
import com.blogapplication.entity.Post;
import com.blogapplication.entity.User;
import com.blogapplication.exception.CategoryNotFoundException;
import com.blogapplication.exception.UserNotFoundException;
import com.blogapplication.payload.PostDto;
import com.blogapplication.payload.PostResponse;
import com.blogapplication.repository.CategoryRepo;
import com.blogapplication.repository.PostRepo;
import com.blogapplication.repository.UserRepo;

@Service
public class PostServiceImple implements PostService {

	@Autowired
	private PostRepo postRespo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private UserRepo userRepo;

//	Method 1 : create or update post
	@Override
	public PostDto upsertPost(PostDto postDto, Integer userId, Integer categoryId) {

//		fetching userId from the database
		User user = this.userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User id not exist"));

//		fetching categoryId from the database
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new CategoryNotFoundException("Category id is not exist"));

		Post post = this.modelMapper.map(postDto, Post.class);

		post.setImageName("default.png");
		post.setAddedDate(new Date());

//	    Set foreign key relationship
		post.setUser(user);

		post.setCategory(cat); // Set foreign key relationship

		Post savedPost = this.postRespo.save(post); // One post details are saved one row
//+---------+------------+---------------------------------------------------------+-------------+--------+---------+-------------+
//| post_id | added_date | content                                                 | image_name  | title  | user_id | category_id |
//+---------+------------+---------------------------------------------------------+-------------+--------+---------+-------------+
//|   1     | 2025-05-23 | Programming language is used to communicate with machine| default.png | post3  |    3    |      1      |
//+---------+------------+---------------------------------------------------------+-------------+--------+---------+-------------+

		return this.modelMapper.map(savedPost, PostDto.class);
	}

//	fetch the posts based on categoryId
	@Override
	// internally it use foreign key for fetch the posts based on categoryId
	public List<PostDto> getPostByCategory(Integer categoryId) {
		// Step 1: Fetch the category by ID
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new CategoryNotFoundException("Category id is not exist"));

		// Step 2: Get all posts that belong to this category
		List<Post> posts = this.postRespo.findByCategory(cat); // SELECT * FROM post WHERE category_id = 1;

		// Step 3: Convert list of Post entities to list of PostDto
		List<PostDto> postDtos = posts.stream().map(post -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		// Step 4: Return the result
		return postDtos;
	}

//    fetch the posts based on userId
	@Override
	public List<PostDto> getPostByUser(Integer userId) {

		User user = this.userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User id is not exist"));

		List<Post> posts = this.postRespo.findAllByUser(user); // SELECT * FROM post WHERE user_id = 1;

		List<PostDto> postDtos = posts.stream().map(post -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		return postDtos;

	}

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

		Sort sort = null;
		if (sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		} else {
			sort = Sort.by(sortBy).descending();
		}
//		as setting conditions for how data should be fetched.
		Pageable p = PageRequest.of(pageNumber, pageSize, sort);

//		Page<Post> contains following methods 

//		| Method in `Page<Post>`        | Description                         |
//		| ----------------------------- | ----------------------------------- |
//		| `getContent()`                | Returns list of `Post` entities     |
//		| `getTotalElements()`          | Total number of records in DB       |
//		| `getTotalPages()`             | Total number of pages               |
//		| `getNumber()`                 | Current page number (0-based)       |
//		| `getSize()`                   | Page size                           |
//		| `isFirst()` / `isLast()`      | Booleans: is it first or last page? |
//		| `hasNext()` / `hasPrevious()` | Navigation helpers                  |

//		we are giving this pagination condition to findAll method
//		and postPage have pageNumber and pageSize , content, totalElements, totalPages, lastPage

		Page<Post> postPage = this.postRespo.findAll(p);
		List<Post> posts = postPage.getContent(); // we want fetch the content of the page using getContent()

		List<PostDto> postDtos = posts.stream().map(post -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDtos);
		postResponse.setPageNumber(postPage.getNumber());
		postResponse.setPageSize(postPage.getSize());
		postResponse.setTotalElements(postPage.getTotalElements());
		postResponse.setTotalPages(postPage.getTotalPages());
		postResponse.setLastPage(postPage.isLast()); // te tells the last is not

		return postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRespo.findById(postId)
				.orElseThrow(() -> new UserNotFoundException("Post id is not exist"));

		return this.modelMapper.map(post, PostDto.class);

	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRespo.findById(postId)
				.orElseThrow(() -> new UserNotFoundException("Post id is not exist"));

		this.postRespo.delete(post);

	}

	@Override
	public List<PostDto> searchPosts(String keyword) {

		List<Post> posts = postRespo.findByTitleContaining(keyword);
		List<PostDto> postDtos = posts.stream().map(post -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postDtos;
	}

}
