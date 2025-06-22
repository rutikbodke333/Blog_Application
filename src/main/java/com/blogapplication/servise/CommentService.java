package com.blogapplication.servise;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogapplication.payload.CommentDto;

@Service

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Long postId);

	CommentDto updateComment(CommentDto commentDto, Long commentId);

	void deleteComment(Long commentId);

	CommentDto getCommentById(Long commentId);

	

	List<CommentDto> getAllComments();

}
