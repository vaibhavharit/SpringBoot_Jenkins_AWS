package com.sporty_shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sporty_shoes.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	public List<Category> findByName(String name) ; 
	
}
	
