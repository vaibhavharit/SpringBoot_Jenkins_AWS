package com.sporty_shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sporty_shoes.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
	
	public Admin findByUsername(String name) ; 

}
