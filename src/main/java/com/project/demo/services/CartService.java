package com.project.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.models.Cart;
import com.project.demo.models.Customer;
import com.project.demo.models.Food;
import com.project.demo.repos.CartRepository;

@Service
public class CartService {

	@Autowired private CartRepository repo;
	@Autowired private CustomerService cservice;
	
	public void save(Cart wl) {
		repo.save(wl);
	}
	
	public List<Cart> findByuserid(int id){
		return repo.findByCustomer(cservice.findById(id));
	}
	
	public void updateQty(int cartid,int qty) {
		Cart c=repo.findById(cartid).get();
		c.setQty(qty);
		repo.save(c);
	}
	
	public void deleteItem(int id) {
		repo.deleteById(id);
	}
	
	public boolean checkexist(Customer customer, Food food) {
		return repo.findByCustomerAndFood(customer, food)!=null;
	}
	
	public void clearCart(Customer cust) {
		//repo.deleteByCustomer(cust);
		repo.deleteAll(repo.findByCustomer(cust));
	}

	public List<Cart> getAllCarts() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
