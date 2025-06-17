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

	PostDto createPost(PostDto postDto, Long userId, Long categoryId);


	PostDto updatePost(PostDto postDto, Long postId);
	
	

	void deletePost(Long postId);

	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	PostDto getPostById(Long postId);

//    get all post by category
	List<PostDto> getPostByCategory(Long categoryId);

//    get all post by user
	List<PostDto> getPostByUser(Long userId);

	// search post by title
	List<PostDto> searchPosts(String keyword);

}
