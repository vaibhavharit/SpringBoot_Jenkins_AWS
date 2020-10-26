package com.sporty_shoes.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import com.sporty_shoes.model.Product;
import com.sporty_shoes.model.Purchase;
import com.sporty_shoes.model.User;
import com.sporty_shoes.service.ProductService;
import com.sporty_shoes.service.PurchaseService;
import com.sporty_shoes.service.UserService;

@RestController
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService ; 
	
	@Autowired
	private UserService userService ; 
	
	@Autowired
	private ProductService productService ; 
	
	
	
	@PostMapping("/admin/purchase/{user_id}/{product_id}")
	public Purchase addPurchase(@RequestBody Purchase purchase, 
			@PathVariable int user_id, @PathVariable int product_id,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		User u ; 
		Product p ; 
		try {
			u = userService.getUserById(user_id) ; 
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The user of the purchase is not found") ; 
		}
		
		try {
			p = productService.getProductById(product_id) ; 
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The product of the purchase is not found") ; 
		}
		
		if(u==null || p==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The product of the purchase is not found") ; 
		}
		
		
		purchase.setProduct(p);
		purchase.setUser(u);
		
		return purchaseService.addPurchase(purchase) ; 
	}
	
	
	@PutMapping("/admin/purchase/{user_id}/{product_id}")
	public Purchase updatePurchase(@RequestBody Purchase purchase, 
			@PathVariable int user_id, @PathVariable int product_id,
			javax.servlet.http.HttpServletRequest request) {
		
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		User u ; 
		Product p ; 
		try {
			u = userService.getUserById(user_id) ; 
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The user of the purchase is not found") ; 
		}
		
		try {
			p = productService.getProductById(product_id) ; 
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The product of the purchase is not found") ; 
		}
		
		if(u==null || p==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The product of the purchase is not found") ; 
		}
		
	
		purchase.setProduct(p);
		purchase.setUser(u);
		
		return purchaseService.updatePurchase(purchase) ;  
	}
	
	
	
	@DeleteMapping("/admin/purchase/{purchase_id}")
	public void deletePurchase(@PathVariable int purchase_id, javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		purchaseService.DeletePurchase(purchase_id);
	}
	
	
	
	@GetMapping("/admin/purchases")
	public List<Purchase> getAllPurchases(javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return purchaseService.getAllPurchases() ;
	}
	
	
	
	@GetMapping("/admin/purchase/{purchase_id}")
	public Purchase getPurchaseById(@PathVariable int purchase_id,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return purchaseService.getPurchaseById(purchase_id) ; 
	}
	
	
	
	@GetMapping("/admin/purchase/date/{date}")
	public List<Purchase> getPurchaseById(@PathVariable String date,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		 LocalDateTime dateTime ; 
		
		try {
			StringBuilder date_string = new StringBuilder() ; 
			date_string.append(date) ; 
			date_string.append(" 00:00:00") ; 
			String actual_date = date_string.toString() ; 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		    dateTime = LocalDateTime.parse(actual_date, formatter);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter the date in a valid YYYY:MM:DD format") ;
		}
		
		
		return purchaseService.getAllPurchasesByDate(dateTime) ; 
	}
	
	
	@GetMapping("/admin/purchase/user/{user_id}")
	public List<Purchase> getPurchaseByUser(@PathVariable int user_id,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return purchaseService.getAllPurchasesByUser(user_id) ; 
	}
	
	@GetMapping("/admin/purchase/product/{product_id}")
	public List<Purchase> getPurchaseByProduct(@PathVariable int product_id,
			javax.servlet.http.HttpServletRequest request) {
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		return purchaseService.getAllPurchasesByProduct(product_id) ; 
	}
	
	
	
}
