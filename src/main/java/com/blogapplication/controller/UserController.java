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

import com.blogapplication.payload.UserDto;
import com.blogapplication.repository.UserRepo;
import com.blogapplication.servise.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

    private final UserRepo userRepo;

	@Autowired
	private UserService userService;

    UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

	@PostMapping("/user")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {

		UserDto createUser = userService.upsertUser(userDto);

		return new ResponseEntity<UserDto>(createUser, HttpStatus.CREATED);

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {
		
		UserDto userById = userService.getUserById(id);
		
		return new ResponseEntity<UserDto>(userById, HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<UserDto>> getAllUser(){
		List<UserDto> allUser = userService.getAllUser();
		
		return new ResponseEntity<List<UserDto>>(allUser, HttpStatus.OK);
	}
	
	@PutMapping("user")
	public ResponseEntity<UserDto> updatedUser(@RequestBody UserDto userDto) {

		UserDto updatedUser = userService.upsertUser(userDto);

		return new ResponseEntity<UserDto>(updatedUser, HttpStatus.CREATED);

	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id)
	{
		userService.deleteUser(id);
		return new ResponseEntity<String>("user deleted", HttpStatus.OK);
	}


}
