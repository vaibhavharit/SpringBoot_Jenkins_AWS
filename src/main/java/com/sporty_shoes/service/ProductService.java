package com.sporty_shoes.service;

import java.util.List;

import com.sporty_shoes.exception.BusinessException;
import com.sporty_shoes.model.Product;

public interface ProductService {
	
	public Product addProduct(Product product) ; 
	public Product updateProduct(Product product) ; 
	public void deleteProduct(int id) ; 
	
	public List<Product> getAllProduct() ; 
	Product getProductById(int id) ; 
	public List<Product> getProductByName(String name)  ; 
	public List<Product> getProductByBrand(String brand)  ; 
	public List<Product> getProductByCategory(int categoryid)  ;

}
