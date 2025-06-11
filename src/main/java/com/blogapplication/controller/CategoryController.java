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
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.payload.CategoryDto;
import com.blogapplication.servise.CategoryService;

import jakarta.validation.Valid;

@RestController
public class CategoryController {

	@Autowired
	public CategoryService categoryService;

	@PostMapping("/category")
	public ResponseEntity<CategoryDto> createCategory(@Valid  @RequestBody CategoryDto categoryDto) {
		CategoryDto createCategory = categoryService.upsertCategory(categoryDto);

		return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id) {
		CategoryDto categorybyId = categoryService.getCategorybyId(id);
		return new ResponseEntity<CategoryDto>(categorybyId, HttpStatus.OK);
	}

	@GetMapping("/category")
	public ResponseEntity<List<CategoryDto>> getAllCategories() {
		List<CategoryDto> allCategory = categoryService.getAllCategory();

		return new ResponseEntity<List<CategoryDto>>(allCategory, HttpStatus.OK);
	}

	@PutMapping("/category")
	public ResponseEntity<CategoryDto> updatedCategory(@Valid  @RequestBody CategoryDto categoryDto) {
		CategoryDto updatedCategory = categoryService.upsertCategory(categoryDto);

		return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
	}

	@DeleteMapping("/category/{id}")
	public ResponseEntity<String> deleteCategorybyId(@PathVariable Integer id) {
		categoryService.deleteById(id);
		return new ResponseEntity<String>("category deleted", HttpStatus.OK);
	}
}
