package com.sporty_shoes.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sporty_shoes.model.Purchase;
import com.sporty_shoes.model.User;


@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{
	
	public List<Purchase> findByDate(LocalDateTime date) ; 
	
	@Query("SELECT p FROM Purchase p WHERE p.user.userid = :userid")
	public List<Purchase> findByUser(int userid) ; 
	
	@Query("SELECT p FROM Purchase p WHERE p.product.productid = :productid")
	public List<Purchase> findByProduct(int productid) ; 

}
