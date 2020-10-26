package com.sporty_shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sporty_shoes.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("SELECT u FROM Product u WHERE u.category.categoryid = :cid")
	public List<Product> findByCategory(int cid) ; 
	
	public List<Product> findByName(String name) ; 
	
	public List<Product> findByBrand(String brand) ; 
}
