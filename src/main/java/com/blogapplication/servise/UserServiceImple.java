package com.blogapplication.servise;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.entity.User;
import com.blogapplication.exception.UserNotFoundException;
import com.blogapplication.payload.UserDto;
import com.blogapplication.repository.UserRepo;


@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper; 

	@Override
	public UserDto upsertUser(UserDto userDto) {
		User user = userDtoToUser(userDto);
		User upserUser = userRepo.save(user);

		return userToUserDto(upserUser);
	}

	@Override
	public UserDto getUserById(Integer id) {
		User user = userRepo.findById(id)
			    .orElseThrow(() -> new UserNotFoundException("User id is not exist"));

		
		return userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());

		return userDtos;
	}

	@Override
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);

	}

	public User userDtoToUser(UserDto userDto) {

		User user = modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setAbout(userDto.getAbout());
//		user.setEmail(userDto.getAbout());
//		user.setPassword(userDto.getPassword());

		return user;

	}

	public UserDto userToUserDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setAbout(user.getAbout());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());

		return userDto;
	}

}
