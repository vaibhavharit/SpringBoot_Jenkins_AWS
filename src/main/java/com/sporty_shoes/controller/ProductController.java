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
import com.sporty_shoes.model.Product;
import com.sporty_shoes.service.CategoryService;
import com.sporty_shoes.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService ;
	
	@Autowired
	private CategoryService categoryService ; 
	
	
	
	@PostMapping("/admin/product/{category_id}")
	public Product addProduct(@RequestBody Product product, 
			@PathVariable int category_id,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
			    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/login.") ; 
	    }	
		
		try {
			Category x = categoryService.getCategoryById(category_id);
			product.setCategory(x);
			return productService.addProduct(product); 
		}catch(Exception e) {
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The category doesn't exist. Violates foreign key relation", e) ; 
		}
		
	}
	
	
	@PutMapping("/admin/product/{category_id}")
	public Product updateProduct(@RequestBody Product product, 
			@PathVariable int category_id,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/login.") ; 
	    }	
		
		
		
		try {
			Category x = categoryService.getCategoryById(category_id);
			product.setCategory(x);
			return productService.addProduct(product); 
		}catch(Exception e) {
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The category doesn't exist. Violates foreign key relation", e) ; 
		}
		
	}
	
	
	@DeleteMapping("/admin/product/{product_id}")
	public void deleteProduct(@PathVariable int product_id,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/login.") ; 
	    }	
		
		
		productService.deleteProduct(product_id);
	}
	
	
	
	@GetMapping("admin/products")
	public List<Product> getAllProducts(javax.servlet.http.HttpServletRequest request) {
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		return productService.getAllProduct() ; 
	}
	
	
	@GetMapping("/admin/product/{product_id}")
	public Product getProductByName(@PathVariable int product_id,
			javax.servlet.http.HttpServletRequest request){
		
		
		HttpSession session = request.getSession();
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return productService.getProductById(product_id) ;  
	}
	
	
	
	@GetMapping("/admin/product/name/{product_name}")
	public List<Product> getProductByName(@PathVariable String product_name,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return productService.getProductByName(product_name) ; 
	}
	
	
	@GetMapping("/admin/product/brand/{product_brand}")
	public List<Product> getProductByBrand(@PathVariable String product_brand,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return productService.getProductByBrand(product_brand) ; 
	}

	
	@GetMapping("/admin/product/category/{category_id}")
	public List<Product> getProductByCategory(@PathVariable int category_id,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return productService.getProductByCategory(category_id) ; 
	}
	
	
}
