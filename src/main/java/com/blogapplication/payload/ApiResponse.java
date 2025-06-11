package com.blogapplication.payload;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiResponse {

	
	private String exCode;
	private String exMsg;
	private LocalDateTime localDateTime;
}
