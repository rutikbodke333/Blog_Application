package com.blogapplication.servise;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.entity.Category;

import com.blogapplication.payload.CategoryDto;
import com.blogapplication.payload.UserDto;
import com.blogapplication.repository.CategoryRepo;

@Service
public class CategoryServiceImple implements CategoryService {

	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	public CategoryRepo categoryRepo;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		

		Category category = modelMapper.map(categoryDto, Category.class);
		

		Category savedCategory = categoryRepo.save(category);
		
		
		return modelMapper.map(savedCategory, CategoryDto.class);
		
		

	}
	
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("category not found with id: " + categoryId));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCategory = categoryRepo.save(category);
		
		return modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = categoryRepo.findAll();
		List<CategoryDto> catDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());
		return catDtos;
	}

	@Override
	public CategoryDto getCategorybyId(Long categoryId) {
		Category category = categoryRepo.findById(categoryId).orElseThrow(  () -> new RuntimeException("category not found with id: " + categoryId));
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public void deleteById(Long categoryId) {
		categoryRepo.deleteById(categoryId);

	}



	

}
