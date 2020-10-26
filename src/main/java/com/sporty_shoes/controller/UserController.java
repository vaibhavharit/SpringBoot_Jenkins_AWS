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

import com.sporty_shoes.model.User;
import com.sporty_shoes.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService ;

	@PostMapping("/admin/user")
	public User addUser(@RequestBody User user,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return userService.addUser(user) ; 
	}

	@PutMapping("/admin/user")
	public User updateUser(@RequestBody User user,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return userService.updateUser(user) ; 
	}

	@DeleteMapping("/admin/user/{user_id}")
	public void deleteUser(@PathVariable int user_id,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		userService.deleteUser(user_id);
	}

	@GetMapping("/admin/user/{user_id}")
	public User getUserById(@PathVariable int user_id,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return userService.getUserById(user_id) ; 
	}

	@GetMapping("/admin/users")
	public List<User> getAllUser(javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return userService.getAllUser() ; 
	}

	@GetMapping("/admin/users/firstname/{firstname}")
	public List<User> getUserByFirstName(@PathVariable String firstname,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return userService.getUserByFirstName(firstname) ; 
	}

	@GetMapping("/admin/users/lastname/{lastname}")
	public List<User> getUserByLastName(@PathVariable String lastname,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return userService.getUserByLastName(lastname) ; 
	}

	@GetMapping("/admin/users/age/{age}")
	public List<User> getUserByAge(@PathVariable int age, javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return userService.getUserByAge(age);
	}

	@GetMapping("/admin/users/emailid/{emailid}")
	public User getUserByEmail(@PathVariable String emailid,
			javax.servlet.http.HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }	
		
		
		return userService.getUserByEmail(emailid) ; 
	} 
	
}
