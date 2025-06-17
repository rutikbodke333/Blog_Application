package com.blogapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogapplication.entity.User;


@Repository
public interface UserRepository   extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);

	User findByEmail(String email); // returns null if user not found

}
