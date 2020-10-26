package com.sporty_shoes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sporty_shoes.exception.BusinessException;
import com.sporty_shoes.model.Category;
import com.sporty_shoes.repository.CategoryRepository;
import com.sporty_shoes.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository ; 

	@Override
	public Category addCategory(Category category) {
		
		try {
			return categoryRepository.save(category) ; 
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't add the category due to a bad request") ; 
		}
		
	}

	@Override
	public Category updateCategory(Category category) {
		
		try {
			return categoryRepository.save(category) ; 
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't add the category due to a bad request") ; 
		}
	}

	@Override
	public void deleteCategory(int id){
		
		try {
			categoryRepository.deleteById(id);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Category you want to delete doesn't exist", e) ; 
		}
		
		
	}

	@Override
	public List<Category> getAllCategories() {
		
		List<Category> categoryList = categoryRepository.findAll() ; 
		
		if(categoryList.size()==0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No categories are currently added") ;
		}
		else {
			return categoryList ; 
		}
		
	}

	@Override
	public Category getCategoryById(int id) {
		
		try {
			Category category =  categoryRepository.findById(id).get(); 
			return category ;
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Category you want to find doesn't exist") ; 
		}
	}
	
	

	@Override
	public List<Category> getCategoriesByName(String name){
		
		List<Category> categoryNameList = categoryRepository.findByName(name) ;  
		
		if(categoryNameList.size()==0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No category found with the given name") ; 
		}
		else {
			return categoryNameList ; 
		}
	}

}
