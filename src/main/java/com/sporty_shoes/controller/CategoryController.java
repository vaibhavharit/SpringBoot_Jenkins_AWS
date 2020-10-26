package com.sporty_shoes.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sporty_shoes.exception.BusinessException;
import com.sporty_shoes.model.Category;
import com.sporty_shoes.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService ; 
	
	
	@PostMapping("admin/category")
	public Category addCategory(@RequestBody Category category,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		return categoryService.addCategory(category);
	}
	
	
	@PutMapping("admin/category")
	public Category updateCategory(@RequestBody Category category,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		return categoryService.updateCategory(category) ; 
	}
	
	
	@DeleteMapping("admin/category/{category_id}")
	public void deleteCategory(@PathVariable int category_id,
			javax.servlet.http.HttpServletRequest request) {
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		categoryService.deleteCategory(category_id); 
	}
	
	
	@GetMapping("admin/categories")
	public List<Category> getAllCategories(javax.servlet.http.HttpServletRequest request){
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		return categoryService.getAllCategories() ;
	}
	
	
	@GetMapping("admin/category/{category_id}")
	public Category getCategoryById(@PathVariable int category_id,
			javax.servlet.http.HttpServletRequest request){
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return categoryService.getCategoryById(category_id) ; 
	}
	
	
	@GetMapping("admin/category/name/{category_name}")
	public List<Category> getCategoriesByName(@PathVariable String category_name,
			javax.servlet.http.HttpServletRequest request) throws BusinessException{
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return categoryService.getCategoriesByName(category_name) ; 
	}
	


}
