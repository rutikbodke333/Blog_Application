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
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.payload.CommentDto;
import com.blogapplication.servise.CommentService;

@RestController
@RequestMapping("/blogapplication/user") // Base path for the controller
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("posts/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Long postId) {
		CommentDto createdComment = this.commentService.createComment(commentDto, postId);
		return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
	}
	
	@GetMapping("comments/{commentId}")
	public ResponseEntity<CommentDto> getCommentById(@PathVariable Long commentId) {
		CommentDto commentDto = this.commentService.getCommentById(commentId);
		return new ResponseEntity<>(commentDto, HttpStatus.OK);
	}
	
	@GetMapping("comments")
	public ResponseEntity<List<CommentDto>> getAllComments() {
		List<CommentDto> comments = this.commentService.getAllComments();
		return new ResponseEntity<>(comments, HttpStatus.OK);
	}
	
	
	@PutMapping("comments/{commentId}")
	public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto, @PathVariable Long commentId) {
		CommentDto updatedComment = this.commentService.updateComment(commentDto, commentId);
		return new ResponseEntity<>(updatedComment, HttpStatus.OK);
	}

	@DeleteMapping("comments/{commentId}")
	public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
	}

}
