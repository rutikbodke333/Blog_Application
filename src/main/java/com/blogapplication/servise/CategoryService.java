package com.blogapplication.servise;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogapplication.payload.CategoryDto;

@Service
public interface CategoryService {
	
	CategoryDto upsertCategory(CategoryDto categoryDto);
	
	List<CategoryDto> getAllCategory();
	
	CategoryDto getCategorybyId(Integer id);
	
	void deleteById(Integer id);

}
