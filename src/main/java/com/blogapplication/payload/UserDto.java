package com.blogapplication.payload;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDto {
//	This annotation are used for validity means user can't write empty value in names or others fields

	
	private int id;
	

	@NotEmpty
	@Size(min=4 , max =  10, message = "name must have min 4 character and mix 10 character")
	private String name;


	@Email
	private String email;


	@NotEmpty
	private String password;
	
	@NotEmpty
	@Size(min=4 , max =  10, message = "name must have min 4 character and mix 10 character")
	private String about;
	

}
