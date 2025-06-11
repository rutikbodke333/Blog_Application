package com.blogapplication.exception;

import java.text.Format.Field;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogapplication.payload.ApiResponse;

@RestControllerAdvice
public class GlobalException  {
	
	
//	@ExceptionHandler(value = UserNotFoundException.class)
//	public ResponseEntity<ApiResponse> UserNotFoundException(UserNotFoundException e){
//		
//		ApiResponse apiRepo = new ApiResponse();
//		apiRepo.setExCode("hx2000");
//		apiRepo.setExMsg(e.getMessage());
//		apiRepo.setLocalDateTime(LocalDateTime.now());
//		
//		return new ResponseEntity<>(apiRepo, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	
	
//	it used for all userDefined exception
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ApiResponse> UserNotFoundException(Exception e){
		
		ApiResponse apiRepo = new ApiResponse();
		apiRepo.setExCode("hx2000");
		apiRepo.setExMsg(e.getMessage());
		apiRepo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<>(apiRepo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value =   MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> beanValidationException(MethodArgumentNotValidException e){
		
		Map<String, String> map = new HashMap<>();
	    e.getBindingResult().getAllErrors().forEach( (error) -> {
	    	String fieldName = ( (FieldError)error ).getField();
	    	String defaultMessage = error.getDefaultMessage();
	    	map.put(fieldName, defaultMessage);
	    });
	    
	    return new ResponseEntity<Map<String,String>>(map, HttpStatus.BAD_REQUEST);
		
	}

}
