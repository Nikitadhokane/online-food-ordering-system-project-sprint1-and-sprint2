package com.project.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.models.Customer;
import com.project.demo.models.Order;
import com.project.demo.repos.OrderRepository;

@Service
public class OrderService {

@Autowired OrderRepository dao;
	
	public Order saveOrder(Order order) {
		
		return dao.save(order);
	}
	
	public void confirm(int id) {
		Order order=dao.findById(id).get();
		order.setStatus("Confirmed");
		dao.save(order);
	}

	
	public List<Order> getAllOrders() {
		
		return dao.findAll();
	}

	
	public List<Order> getCustomerOrders(Customer customer) {
		
		return dao.findByCustomer(customer);
	}

	
	public Order findById(int id) {
		
		return dao.findById(id).get();
	}
	
}
