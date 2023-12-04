package com.project.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Food name cannot be blank")
	private String fname;
	
	@NotBlank(message = "Description cannot be blank")
	private String descr;
	
	@ManyToOne
	@JoinColumn(name = "cat_id")
	@NotNull(message = "Category cannot be null")
	private Category category;
	
	@Positive(message = "Price must be a positive value")
	private int price;
	
	private String photo;
	
	
	public Food(int id) {
		this.id = id;
	}
	
	
}
