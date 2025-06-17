package com.blogapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapplication.entity.Comment;

public interface CommentRepo  extends JpaRepository<Comment, Long> {
	
	

}
