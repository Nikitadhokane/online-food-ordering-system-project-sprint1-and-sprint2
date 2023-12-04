package com.project.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Admin {

	@Id
	private String userid;
	
	@JsonIgnore
	@NotBlank(message = "Password cannot be blank")
	private String pwd;
	
	@NotBlank(message = "Username cannot be blank")
	private String uname;

	
	
}
