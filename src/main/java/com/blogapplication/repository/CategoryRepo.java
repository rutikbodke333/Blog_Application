package com.blogapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogapplication.entity.Category;

@Repository
public interface CategoryRepo  extends JpaRepository<Category, Long> {
	

}
