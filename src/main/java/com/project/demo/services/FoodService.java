package com.project.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.demo.models.Food;
import com.project.demo.repos.FoodRepository;
import com.project.demo.utils.StorageService;

@Service
public class FoodService {

	@Autowired private StorageService storageService;
	@Autowired private FoodRepository dao;
	@Autowired private CategoryService cdao;
	
	public void addFood(Food b, MultipartFile pic) {
		String photo=storageService.store(pic);
		b.setPhoto(photo);
		dao.save(b);
	}

	public void updateFood(Food b) {
		dao.save(b);
	}

	public void deleteFood(int id) {
		dao.deleteById(id);
	}

	public List<Food> allFoods() {
		return dao.findAll();
	}
	
	public List<Food> searchFoods(String search) {
		return dao.findByFnameOrDescrContaining(search,search);
	}

	public Food findFoodById(int fodid) {
		return dao.findById(fodid).get();
	}

	public List<Food> categoryFoods(int catid) {
		return dao.findByCategory(cdao.findById(catid));
	}
}
