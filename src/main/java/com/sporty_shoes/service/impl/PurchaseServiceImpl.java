package com.sporty_shoes.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sporty_shoes.model.Purchase;
import com.sporty_shoes.repository.PurchaseRepository;
import com.sporty_shoes.service.PurchaseService;


@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	
	@Autowired
	private PurchaseRepository purchaseRepository ; 

	@Override
	public Purchase addPurchase(Purchase purchase) {
		return purchaseRepository.save(purchase) ; 
	}

	@Override
	public Purchase updatePurchase(Purchase purchase) {
		return purchaseRepository.save(purchase) ; 
	}

	@Override
	public void DeletePurchase(int id) {
		
		try{
			purchaseRepository.deleteById(id);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The purchase ID is not a valid one", e) ; 
		}
	}
	
	

	@Override
	public List<Purchase> getAllPurchases() {
		
		List<Purchase> purchaseList= purchaseRepository.findAll() ; 
		
		if(purchaseList.size()==0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The purchase list is empty as of now") ; 
		}
		else {
			return purchaseList ; 
		}
	}

	
	
	@Override
	public Purchase getPurchaseById(int id) {
		
		
		try {
			Purchase purchase= purchaseRepository.findById(id).get() ; 
			return purchase ; 
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The purchase with the requested ID is not found") ; 
		}
	}

	
	
	@Override
	public List<Purchase> getAllPurchasesByDate(LocalDateTime date) {
		
		List<Purchase> purchaseList= purchaseRepository.findByDate(date) ; 
		
		if(purchaseList.size()==0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No purchases found for the given date") ; 
		}
		else {
			return purchaseList ; 
		}
		
	}

	
	
	@Override
	public List<Purchase> getAllPurchasesByUser(int userid) {
		
		List<Purchase> purchaseList= purchaseRepository.findByUser(userid) ; 
		
		if(purchaseList.size()==0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No purchases found for the given User") ; 
		}
		else {
			return purchaseList ; 
		}
		
	}

	
	
	@Override
	public List<Purchase> getAllPurchasesByProduct(int productid) {
		
		List<Purchase> purchaseList= purchaseRepository.findByProduct(productid) ; 
		
		if(purchaseList.size()==0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No purchases found for the given Product") ; 
		}
		else {
			return purchaseList ; 
		}		
	}

}
