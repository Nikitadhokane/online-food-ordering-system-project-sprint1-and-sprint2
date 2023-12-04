package com.project.demo.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	
	@NotNull(message = "Order date cannot be null")
	private LocalDate orderDate;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	@NotNull(message = "Customer cannot be null")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="addressId")
	@NotNull(message = "Address cannot be null")
	private Address address;
	
	@ManyToOne
	@JoinColumn(name="paymentId")
	@NotNull(message = "Payment cannot be null")
	private Payment payment;
	
	@NotBlank(message = "Payment method cannot be blank")
	private String paymethod;
	
	@NotBlank(message = "Status cannot be blank")
	private String status;
	
	@OneToMany(mappedBy = "order" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@NotNull(message = "Order details cannot be null")
	private List<OrderDetails> orderdetails;
	
}
