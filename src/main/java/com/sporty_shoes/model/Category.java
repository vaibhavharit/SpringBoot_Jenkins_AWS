package com.sporty_shoes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {
	
	@Id
	@TableGenerator(name="catGen", initialValue=3)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="catGen")
	private int categoryid ; 
	
	private String name ; 
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="category", cascade=CascadeType.ALL)
	private List<Product> products = new ArrayList<>();
	
	
	public Category() {
		
	}
	

	public Category(String name) {
		super();
		this.name = name;
	}


	public int getCategoryid() {
		return categoryid;
	}


	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


//	public List<Product> getProducts() {
//		return products;
//	}


	public void addProduct(Product product) {
		this.products.add(product) ; 
	}
	
	
	public void deleteProduct(Product product) {
		this.products.remove(product) ;  
	}


	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + ", products=" + products + "]";
	}


}
