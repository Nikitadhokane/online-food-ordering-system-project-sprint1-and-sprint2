package com.project.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.models.Category;
import com.project.demo.repos.CategoryRepository;

@Service
public class CategoryService {

	@Autowired private CategoryRepository repo;
	
	public void save(Category cat) {
		repo.save(cat);
	}
	
	public List<Category> listAll(){
		return repo.findAll();
	}
	
	public Category findById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public void deleteCategory(int id) {
		repo.deleteById(id);
	}
}
