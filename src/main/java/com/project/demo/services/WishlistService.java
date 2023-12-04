package com.project.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dtos.WishlistDTO;
import com.project.demo.models.Food;
import com.project.demo.models.Wishlist;
import com.project.demo.repos.WishlistRepository;

@Service
public class WishlistService {

	@Autowired private WishlistRepository repo;
	@Autowired private CustomerService cservice;
	
	public void save(WishlistDTO dto) {
		Wishlist wl=new Wishlist();
		wl.setFood(dto.getFood());
		wl.setCustomer(cservice.findById(dto.getCustid()));
		repo.save(wl);
	}
	
	public List<Wishlist> findByuserid(int id){
		return repo.findByCustomer(cservice.findById(id));
	}
	
	public void deleteItem(int id) {
		repo.deleteById(id);
	}
	
	public boolean checkexist(int custid,Food food) {
		return repo.findByCustomerAndFood(cservice.findById(custid), food)!=null;
	}
}
