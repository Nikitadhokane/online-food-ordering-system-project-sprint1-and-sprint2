package com.project.demo.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDTO {

	
	private int id;
	
	@NotNull(message = "Category cannot be null")
	private String cat;
	
	@NotNull(message = "Name cannot be null")
	private String bname;
	
	@Positive(message = "Price must be a positive value")
	private int price;
	
	@Min(value = 0, message = "Quantity must be a non-negative value")
	private int qty;
	
	
}
