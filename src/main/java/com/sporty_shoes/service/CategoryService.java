package com.sporty_shoes.service;

import java.util.List;
import java.util.Optional;

import com.sporty_shoes.exception.BusinessException;
import com.sporty_shoes.model.Category;

public interface CategoryService {
	
	public Category addCategory(Category category) ; 
	public Category updateCategory(Category category) ;
	public void deleteCategory(int id) ; 
	
	public List<Category> getAllCategories(); 
	public Category getCategoryById(int id) ; 
	public List<Category> getCategoriesByName(String cat_name); 
	
	
}
