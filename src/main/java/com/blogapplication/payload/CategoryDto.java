package com.blogapplication.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

	private Long categoryId;

	@NotBlank
	@Size(min = 2, max = 20, message = "category title must be min of 2 characters and max of 20 characters !!")
	private String categoryTitle;

	@NotBlank
	@Size(min = 10, max = 500, message = "category description must be min of 10 characters and max of 500 characters !!")
	private String categoryDescription;

}
