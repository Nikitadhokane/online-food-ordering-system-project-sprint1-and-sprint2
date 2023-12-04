package com.project.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
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
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "City cannot be blank")
	private String city;
	
	@NotBlank(message = "State cannot be blank")
	private String state;
	
	@NotBlank(message = "Zip code cannot be blank")
    @Size(min = 5, max = 10, message = "Zip code must be between 5 and 10 characters")
    private String zip;
	
	@NotBlank(message = "Country cannot be blank")
	private String country;
	
	
}
