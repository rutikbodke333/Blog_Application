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

import com.blogapplication.payload.CategoryDto;
import com.blogapplication.servise.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blogapplication/user") 
public class CategoryController {

	@Autowired
	public CategoryService categoryService;

	@PostMapping("/category")
	public ResponseEntity<CategoryDto> createCategory(@Valid  @RequestBody CategoryDto categoryDto) {
		CategoryDto createCategory = categoryService.createCategory(categoryDto);

		return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
	}

	@PutMapping("/category/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable Long categoryId) {
		CategoryDto updatedCategory = categoryService.updateCategory(categoryDto, categoryId);

		return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long categoryId) {
		CategoryDto categorybyId = categoryService.getCategorybyId(categoryId);
		return new ResponseEntity<CategoryDto>(categorybyId, HttpStatus.OK);
	}

	@GetMapping("/category")
	public ResponseEntity<List<CategoryDto>> getAllCategories() {
		List<CategoryDto> allCategory = categoryService.getAllCategory();

		return new ResponseEntity<List<CategoryDto>>(allCategory, HttpStatus.OK);
	}


	@DeleteMapping("/category/{categoryId}")
	public ResponseEntity<String> deleteCategorybyId(@PathVariable Long categoryId) {
		categoryService.deleteById(categoryId);
		return new ResponseEntity<String>("category deleted successfully", HttpStatus.OK);
	}
}
