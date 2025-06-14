package com.blogapplication.payload;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blogapplication.entity.Category;
import com.blogapplication.entity.Comment;
import com.blogapplication.entity.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class PostDto {

	private Integer postId;

	@NotBlank(message = "title cannot be blank")
	@Size(min = 4, max = 50, message = "title must be between 4 and 100 characters")
	private String title;

	@NotBlank(message = "content cannot be blank")
	@Size(min = 10, max = 500, message = "content must be between 10 and 500 characters")
	private String content;

	private String imageName;

	private Date addedDate;

	private CategoryDto category;

	private UserDto user;

	private Set<CommentDto> comments = new HashSet<>();

}
