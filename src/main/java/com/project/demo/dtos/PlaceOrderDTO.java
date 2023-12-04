package com.project.demo.dtos;

import javax.validation.constraints.NotNull;

import com.project.demo.models.Address;
import com.project.demo.models.Payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceOrderDTO {

	@NotNull(message = "Address cannot be null")
	private Address address;
	
	@NotNull(message = "Payment cannot be null")
	private Payment payment;
	
	@NotNull(message = "customerid cannot be null")
	private int customerid;
	
	@NotNull(message = "Payment method date cannot be null")
	private String paymethod;
	
	
}
