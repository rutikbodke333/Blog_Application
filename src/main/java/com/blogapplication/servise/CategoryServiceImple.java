package com.blogapplication.servise;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.entity.Category;
import com.blogapplication.exception.CategoryNotFoundException;
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
	public CategoryDto upsertCategory(CategoryDto categoryDto) {
		Category categoy = categoryDtoToCategory(categoryDto);
		Category savedCategory = categoryRepo.save(categoy);
		return categoryToCategoryDto(savedCategory);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = categoryRepo.findAll();
		List<CategoryDto> catDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());
		return catDtos;
	}

	@Override
	public CategoryDto getCategorybyId(Integer id) {
		Category category = categoryRepo.findById(id).orElseThrow(  () -> new CategoryNotFoundException("category id is not exist"));
		return categoryToCategoryDto(category);
	}

	@Override
	public void deleteById(Integer id) {
		categoryRepo.deleteById(id);

	}

	public Category categoryDtoToCategory(CategoryDto categoryDto) {

		Category category = modelMapper.map(categoryDto, Category.class);

		return category;

	}

	public CategoryDto  categoryToCategoryDto (Category category) {

		CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);

		return categoryDto;
	}

}
