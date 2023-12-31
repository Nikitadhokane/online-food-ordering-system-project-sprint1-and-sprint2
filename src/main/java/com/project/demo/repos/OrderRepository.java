package com.project.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.models.Customer;
import com.project.demo.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByCustomer(Customer customer);
}
