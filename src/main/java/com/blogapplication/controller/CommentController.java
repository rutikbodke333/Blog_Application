package com.blogapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.payload.CommentDto;
import com.blogapplication.servise.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("posts/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId) {
		CommentDto createdComment = this.commentService.upsertComment(commentDto, postId);
		return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
	}

	@DeleteMapping("comments/{commentId}")
	public ResponseEntity<String> deleteComment(@PathVariable Integer commentId) {
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
	}

}
