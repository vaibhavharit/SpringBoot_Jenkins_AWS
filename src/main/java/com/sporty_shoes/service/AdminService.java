package com.sporty_shoes.service;

import java.util.List;

import com.sporty_shoes.exception.BusinessException;
import com.sporty_shoes.model.Admin;

public interface AdminService {
	
	public Admin createAdmin(Admin admin) ; 
	public void deleteAdminById(String username) ; 
	
	public List<Admin> getAllAdmins() throws BusinessException ; 
	public Admin getAdminByUserName(String name) ; 

}
