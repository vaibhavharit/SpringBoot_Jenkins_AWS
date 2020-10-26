package com.sporty_shoes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sporty_shoes.exception.BusinessException;
import com.sporty_shoes.model.Admin;
import com.sporty_shoes.repository.AdminRepository;
import com.sporty_shoes.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{


	@Autowired
	private AdminRepository adminRepository ; 
	

	@Override
	public Admin createAdmin(Admin admin) {
		try {
			Admin a = adminRepository.save(admin) ; 
			return a ; 
		}catch(Exception e){
			 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter valid admin details to create new admin") ; 
		}
		
	}
	

	@Override
	public void deleteAdminById(String username) {
		try {
			adminRepository.deleteById(username);
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter valid admin username to delete existing admin", e) ; 
		}
		
		
	}

	@Override
	public List<Admin> getAllAdmins() throws BusinessException {
		
		List<Admin> adminList = adminRepository.findAll() ; 
		
		if(adminList.size()==0) {
			throw new BusinessException("There are currently no admin at present") ; 
		}
		
		else {
			return adminList ; 
		}
	}


	@Override
	public Admin getAdminByUserName(String name) {
		Admin a = adminRepository.findByUsername(name) ; 
		
		if(a==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Enter valid admin username to get existing admin. Admin not found") ; 
		}
		else {
			return a ; 
		}
	
	}

	


}
