package com.sporty_shoes.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
public class Purchase {

	@Id
	@TableGenerator(name="purGen", initialValue=6)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="purGen")
	private int purchaseid ; 
	
	private int quantity ;
	private LocalDateTime date ; 
	
	@ManyToOne
	private User user ; 
	
	@ManyToOne
	private Product product ;
	
	
	public Purchase() {
		
	}
	
	
	public Purchase(int quantity, LocalDateTime date, User user, Product product) {
		super();
		this.quantity = quantity;
		this.date = date;
		this.user = user;
		this.product = product;
	} 

	public int getPurchaseid() {
		return purchaseid;
	}

	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


}
