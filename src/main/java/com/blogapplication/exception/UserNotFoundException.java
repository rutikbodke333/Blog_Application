package com.blogapplication.exception;

public class UserNotFoundException  extends RuntimeException{
	
	public UserNotFoundException(String msg) {
		super(msg);
	}

}
