package com.project.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.models.Payment;
import com.project.demo.repos.PaymentRepository;

@Service
public class PaymentService {

	@Autowired PaymentRepository dao;
	
	public Payment savePayment(Payment payment) {
		return dao.save(payment);
	}

	public Payment findPaymentById(int id) {
		return dao.findById(id).get();
	}
	
}
