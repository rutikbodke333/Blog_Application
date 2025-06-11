package com.blogapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapplication.entity.Category;
import com.blogapplication.entity.Post;
import com.blogapplication.entity.User;
import com.blogapplication.payload.PostDto;

public interface PostRepo  extends JpaRepository<Post, Integer>{
	
	List<Post> findAllByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);

}
