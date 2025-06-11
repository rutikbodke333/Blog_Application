package com.blogapplication.payload;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blogapplication.entity.Category;
import com.blogapplication.entity.Comment;
import com.blogapplication.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class PostDto {

	private Integer postId;

	private String title;

	private String content;

	private String imageName;

	private Date addedDate;

	private CategoryDto category;

	private UserDto user;
	
	private Set<CommentDto> comments = new HashSet<>();

}

