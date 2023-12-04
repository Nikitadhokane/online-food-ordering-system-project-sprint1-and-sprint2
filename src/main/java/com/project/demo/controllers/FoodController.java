package com.project.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.dtos.FoodDTO;
import com.project.demo.dtos.Response;
import com.project.demo.models.Food;
import com.project.demo.services.FoodService;


@CrossOrigin
@RestController
@RequestMapping("/api/foods")
public class FoodController {

@Autowired FoodService bservice;
	
	@PostMapping
	public ResponseEntity<?> saveFood(FoodDTO dto) {
		System.out.println(dto);
		Food food=FoodDTO.toEntity(dto);
		bservice.addFood(food,dto.getPic());
		return Response.success(food);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateFood(@RequestBody Food food,@PathVariable("id") int id) {
		bservice.updateFood(food);
		return Response.success(food);		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findFood(@PathVariable("id")int id) {
		Food food=bservice.findFoodById(id);
		return Response.success(food);
	}
	
	@GetMapping
	public List<Food> findAllFoods(Optional<String> search) {
		List<Food> result = new ArrayList<Food>();
		if(search.isPresent()) {
			for(Food b : bservice.searchFoods(search.get())) {
				result.add(b);
			}
		}else {
			for(Food b : bservice.allFoods()) {
				result.add(b);
			}
		}
		return result;
	}
	
	
	@GetMapping("cats")
	public List<Food> findByCategory(int catid) {
		List<Food> result = new ArrayList<Food>();
		
		for(Food b : bservice.categoryFoods(catid)) {
			result.add(b);
		}
		
		return result;
	}
		
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteFood(@PathVariable("id") int id) {
		bservice.deleteFood(id);
		return Response.status(HttpStatus.OK);
	}
	
}
