package com.blogapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blogapplication.entity.PaginationResponce;
import com.blogapplication.payload.UserDto;
import com.blogapplication.repository.UserRepository;
import com.blogapplication.servise.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blogapplication") 
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@PostMapping("/admin/register")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createdUser = userService.createUser(userDto);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@PutMapping("/user/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Long userId) {
		UserDto updateUser = userService.updateUser(userDto, userId);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}

	

	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
		UserDto userById = userService.getUserById(userId);
		return new ResponseEntity<>(userById, HttpStatus.OK);
	}

	@GetMapping("/user/allUsers")
	public ResponseEntity<PaginationResponce> getAllUsers(@RequestParam(defaultValue = "0") Integer pageNumber,
			@RequestParam(defaultValue = "15") Integer pageSize, @RequestParam(defaultValue = "name") String sortBy,
			@RequestParam(defaultValue = "asc") String sortDir) {
		PaginationResponce paginationResponse = userService.getAllUsers(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(paginationResponse, HttpStatus.OK);
	}


	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteById(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to the Blog Application!";
	}
}
