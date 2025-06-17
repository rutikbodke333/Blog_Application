package com.blogapplication.servise;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogapplication.entity.PaginationResponce;
import com.blogapplication.payload.UserDto;

@Service
public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto, Long adminId);
	
	UserDto getUserById(Long userId);
	
	PaginationResponce getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	void deleteUser(Long userId);
	
	public UserDto registerUser(UserDto userDto);
	
	
	

}
