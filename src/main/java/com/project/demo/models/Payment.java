package com.project.demo.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
@Table(name="payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Card number cannot be blank")
    @Pattern(regexp = "\\d{16}", message = "Card number must be 16 digits")
	private String cardno;
	
	@NotBlank(message = "Name on card cannot be blank")
	private String nameoncard;
	
	@NotNull
	@Positive(message = "Amount must be a positive value")
	private int amount;
	
	@NotNull(message = "Payment date cannot be null")
	private LocalDate paymentdate;
	
	
	
}
