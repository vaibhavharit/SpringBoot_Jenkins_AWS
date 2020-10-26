package com.sporty_shoes.service;

import java.time.LocalDateTime;
import java.util.List;

import com.sporty_shoes.model.Purchase;

public interface PurchaseService {
	
	public Purchase addPurchase(Purchase purchase) ; 
	public Purchase updatePurchase(Purchase purchase) ; 
	public void DeletePurchase(int id) ; 
	
	
	public List<Purchase> getAllPurchases() ; 
	public Purchase getPurchaseById(int id) ; 
	public List<Purchase> getAllPurchasesByDate(LocalDateTime date) ; 
	public List<Purchase> getAllPurchasesByUser(int userid) ; 
	public List<Purchase> getAllPurchasesByProduct(int productid) ; 

}
