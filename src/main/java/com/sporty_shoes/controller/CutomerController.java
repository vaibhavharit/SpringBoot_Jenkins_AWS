package com.sporty_shoes.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sporty_shoes.model.Category;
import com.sporty_shoes.model.Product;
import com.sporty_shoes.service.CategoryService;
import com.sporty_shoes.service.ProductService;

@RestController
public class CutomerController {
	
	@Autowired
	private ProductService productService ;
	@Autowired
	private CategoryService categoryService ;
	
	
	
	@GetMapping("/products")
	public List<Product> getAllProducts(javax.servlet.http.HttpServletRequest request) {
		
		return productService.getAllProduct() ; 
	}
	
	@GetMapping("/categories")
	public List<Category> getAllCategories(){
		
		return categoryService.getAllCategories() ;
	}
	
	
	@GetMapping("product/category/{category_id}")
	public List<Product> getProductByCategory(@PathVariable int category_id) {
		
		return productService.getProductByCategory(category_id) ; 
	}
	
	

}
