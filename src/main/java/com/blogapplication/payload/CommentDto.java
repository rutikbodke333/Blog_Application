package com.blogapplication.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {
	
	private Long id;
	
	@NotBlank(message = "content cannot be blank")
	@Size(min = 5, max = 500, message = "content must be between 5 and 500 characters")
	private String content;

}
