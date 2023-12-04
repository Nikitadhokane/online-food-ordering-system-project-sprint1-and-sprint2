package com.project.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="foodid")
	@NotNull(message = "Food cannot be null")
	private Food food;
	
	@Min(value = 1, message = "Quantity must be at least 1")
	private int qty;
	
	@ManyToOne
	@JoinColumn(name="orderId")
	@JsonIgnore
	@NotNull(message = "Order cannot be null")
	private Order order;
	
	
	
}
