package com.project.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @NotBlank(message = "Name cannot be blank")
	private String name;
    
    @NotBlank(message = "City cannot be blank")
	private String city;
    
    @NotBlank(message = "User ID cannot be blank")
	private String userid;
    
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
	private String pwd;
    
    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;

    @NotBlank(message = "Gender cannot be blank")
    private String gender;
	
	
	public Customer(int id) {
		this.id = id;
	}
	
	
}
