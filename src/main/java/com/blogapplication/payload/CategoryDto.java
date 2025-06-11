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

	private Integer categoryId;

	@NotBlank
	@Size(min = 4, message = "Title must be min of 4 characters !!")
	private String categoryTitle;

	@NotBlank
	@Size(min = 10, message = "Description must be min of 10 characters !!")
	private String categoryDescription;

}
