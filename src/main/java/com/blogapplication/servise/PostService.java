package com.blogapplication.servise;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogapplication.entity.Post;
import com.blogapplication.payload.PostDto;
import com.blogapplication.payload.PostResponse;

//import com.blog.app.entity.Post;
//import com.blog.app.paylods.PostDto;

@Service
public interface PostService {

	PostDto upsertPost(PostDto postDto, Integer userId, Integer categoryId);

//	Post updatePost(PostDto postDto, Integer postId);

	void deletePost(Integer postId);

	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	PostDto getPostById(Integer postId);

//    get all post by category
	List<PostDto> getPostByCategory(Integer categoryId);

//    get all post by user
	List<PostDto> getPostByUser(Integer userId);

	// search post by title
	List<PostDto> searchPosts(String keyword);

}
