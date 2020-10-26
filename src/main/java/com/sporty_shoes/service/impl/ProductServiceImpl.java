package com.sporty_shoes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sporty_shoes.exception.BusinessException;
import com.sporty_shoes.model.Product;
import com.sporty_shoes.repository.ProductRepository;
import com.sporty_shoes.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository ; 

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product) ; 
	}
	
	

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product) ; 
	}
	
	

	@Override
	public void deleteProduct(int id) {
		
		try {
			productRepository.deleteById(id);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The product ID to delete doesn't exist", e) ; 
		}
		
	}

	@Override
	public List<Product> getAllProduct(){
		
		List<Product> prodList = productRepository.findAll() ;  
		
		if(prodList.size()==0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The product list is currently empty") ; 
		}
		else {
			return productRepository.findAll() ; 
		}
		
	}

	@Override
	public Product getProductById(int id) {
		
		try{
			Product p = productRepository.findById(id).get() ; 
			return p ; 
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The product with the ID requested doesn't exist") ; 
		}
		
	}

	@Override
	public List<Product> getProductByName(String name) {
		
		List<Product> prodList = productRepository.findByName(name);  
		
		if(prodList.size()==0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No products found with the given name") ; 
		}
		else {
			return prodList ; 
		}
		
	}

	@Override
	public List<Product> getProductByBrand(String brand)  {
		
		List<Product> prodList = productRepository.findByBrand(brand);
		
		if(prodList.size()==0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No products found with the given brand") ; 
		}
		else {
			return prodList ; 
		}
		
	}

	@Override
	public List<Product> getProductByCategory(int categoryid){
		
		List<Product> prodList = productRepository.findByCategory(categoryid) ; 
		
		if(prodList.size()==0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No products found with the given category") ; 
		}
		else {
			return prodList ; 
		}
		
	}

	
}
