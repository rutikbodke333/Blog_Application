package com.blogapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.config.AppConstant;
import com.blogapplication.payload.PostDto;
import com.blogapplication.payload.PostResponse;
import com.blogapplication.servise.PostService;

@RestController
//@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		PostDto createPost = this.postService.upsertPost(postDto, userId, categoryId);

		return new ResponseEntity<>(createPost, HttpStatus.CREATED);

	}

	// Get by user
	@GetMapping("user/{userId}/posts")
	// user/{userId}/posts means we have fetch the posts whose userId is
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {

		List<PostDto> postDtos = this.postService.getPostByUser(userId);

		return new ResponseEntity<>(postDtos, HttpStatus.OK);

	}

	// Get by category
	@GetMapping("category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId) {

		List<PostDto> postDtos = this.postService.getPostByCategory(categoryId);

		return new ResponseEntity<>(postDtos, HttpStatus.OK);

	}

	// Get all posts
	@GetMapping("posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = AppConstant.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstant.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstant.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstant.SORT_DIR, required = false) String sortDir) {

		PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(postResponse, HttpStatus.OK);

	}

	// Get by postId
	@GetMapping("posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {

		PostDto postDtos = this.postService.getPostById(postId);

		return new ResponseEntity<>(postDtos, HttpStatus.OK);

	}

	// update post
	@PutMapping("user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		PostDto createPost = this.postService.upsertPost(postDto, userId, categoryId);

		return new ResponseEntity<>(createPost, HttpStatus.OK);

	}

	// delete post
	@DeleteMapping("posts/{postId}")
	public ResponseEntity<String> deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);

	}

	// search posts or list of posts by keyword
	@GetMapping("posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPost(@PathVariable String keyword) {
		List<PostDto> postDtos = this.postService.searchPosts(keyword);
		return new ResponseEntity<>(postDtos, HttpStatus.OK);

	}

}
