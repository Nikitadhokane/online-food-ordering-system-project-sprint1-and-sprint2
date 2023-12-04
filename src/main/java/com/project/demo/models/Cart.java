package com.project.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@NotNull(message = "Customer cannot be null")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="food_id")
	@NotNull(message = "Food cannot be null")
	private Food food;
	
	@Min(value = 0, message = "Quantity must be a non-negative value")
	private int qty;
	
	
}
