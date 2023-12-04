package com.project.demo.dtos;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.project.demo.models.Order;


public class OrderResponseDTO {

	@NotNull(message = "Food cannot be null")
	private Order order;
	private List<OrderDetailsDTO> details;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<OrderDetailsDTO> getDetails() {
		return details;
	}
	public void setDetails(List<OrderDetailsDTO> details) {
		this.details = details;
	}
	
	
}
