package com.blogapplication.servise;

import org.springframework.stereotype.Service;

import com.blogapplication.payload.CommentDto;

@Service

public interface CommentService {
	
	CommentDto upsertComment(CommentDto commentDto, Integer postId);
	
	void deleteComment(Integer commentId);

}
