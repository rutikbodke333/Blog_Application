package com.blogapplication.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDto {
//	This annotation are used for validity means user can't write empty value in names or others fields

	private int id;

	@NotBlank(message = "Name must be not blank")
	@Size(min = 4, max = 20, message = "name must have min 4 character and mix 10 character")
	private String name;

	@NotBlank(message = "Email must be not blank")
	@Size(min = 10, max = 30, message = "Email must have min 10 characters and max 30 characters")
	@Email(message = "Email should be valid")
	private String email;

	@NotBlank(message = "Password must be not blank")
	@Size(min = 6, max = 20, message = "Password must have min 6 characters and max 20 characters")
	private String password;

	@NotBlank(message = "About must be not blank")
	@Size(min = 4, max = 20, message = "name must have min 4 character and mix 20 character")
	private String about;

	private String role;

}
