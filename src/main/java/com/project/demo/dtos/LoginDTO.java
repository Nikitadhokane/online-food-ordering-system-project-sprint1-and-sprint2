package com.project.demo.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO {
	
	
	private String userid;
	
	@NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
	private String pwd;
	
	@NotNull(message = "role cannot be null")
	private String role;
	
	
	
}
