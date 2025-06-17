package com.blogapplication.servise;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogapplication.payload.CategoryDto;

@Service
public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);
	
	List<CategoryDto> getAllCategory();
	
	CategoryDto getCategorybyId(Long categoryId);
	
	void deleteById(Long categoryId);

}
