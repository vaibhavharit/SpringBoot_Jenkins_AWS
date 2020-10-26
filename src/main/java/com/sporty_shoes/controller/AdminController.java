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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sporty_shoes.exception.BusinessException;
import com.sporty_shoes.model.Admin;
import com.sporty_shoes.repository.AdminRepository;
import com.sporty_shoes.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService ; 
	
	@PostMapping("/admin/login")
	public Admin login(@RequestBody Admin admin, javax.servlet.http.HttpServletRequest request) {
		String username = admin.getUsername() ; 
		String password = admin.getPassword() ; 
		
		Admin a = adminService.getAdminByUserName(username) ; 
		
		
		if(a==null) {
			
			System.out.println("a is null");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No admin found for the entered username") ; 
		}
	
		
		if(a.getPassword().equals(password)==false) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect password entered. Please try again") ; 
		}
		
		
		HttpSession session = request.getSession();
		session.setAttribute("admin_id", a.getUsername()) ; 
		
		return admin;
		
	}
	
	
	@GetMapping("/admin/logout")
	public void logout(javax.servlet.http.HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("admin_id") == null) {
			  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
		   }
		
	  	session.invalidate();
	}
	
	 
	
	@PutMapping("/admin/changePassword")
	public Admin changePassword(@RequestBody Admin admin, javax.servlet.http.HttpServletRequest request) {
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }
		
		if (session.getAttribute("admin_id").equals(admin.getUsername())==false) {
			  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You are unauthorized to change another admin's password") ; 
		}
		
		String password = admin.getPassword() ; 
		
		
		admin.setPassword(password);
		
		return adminService.createAdmin(admin) ; 
		
	}
	
	@PostMapping("/admin")
	public Admin createAdmin(@RequestBody Admin admin, javax.servlet.http.HttpServletRequest request) {
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }
		
		return adminService.createAdmin(admin) ; 
		
	}
	
	@DeleteMapping("/admin/{username}")
	public void deleteAdmin(@PathVariable String username, javax.servlet.http.HttpServletRequest request) {
		
		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }
		
		adminService.deleteAdminById(username);
	}
	
	
	@GetMapping("/admins")
	public List<Admin> getAllAdmins(javax.servlet.http.HttpServletRequest request) throws BusinessException{

		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }		
		
		return adminService.getAllAdmins() ; 
	}
	
	
	@GetMapping("/admin/name/{username}")
	public Admin getAdminByName(@PathVariable String username, javax.servlet.http.HttpServletRequest request){

		HttpSession session = request.getSession();
	    
		if (session.getAttribute("admin_id") == null) {
		  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login to access the functionality. Visit localhost:8080/admin/login") ; 
	    }		
		
		return adminService.getAdminByUserName(username) ; 
	}
	
	

}
