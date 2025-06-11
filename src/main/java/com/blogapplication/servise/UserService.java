package com.blogapplication.servise;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogapplication.payload.UserDto;

@Service
public interface UserService {
	
	UserDto upsertUser(UserDto userDto);
	
	UserDto getUserById(Integer id);
	
	List<UserDto> getAllUser();
	
	void deleteUser(Integer id);
	
	
	

}
