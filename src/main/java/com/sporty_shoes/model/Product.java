package com.sporty_shoes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
	
	@Id
	@TableGenerator(name="prodGen", initialValue=7)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="prodGen")
	private int productid ; 
	
	private String name ; 
	private String brand ; 
	private int price ; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category ; 
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="product")
	private List<Purchase> purchaselist = new ArrayList<>() ; 
	
	
	public Product() {
		
	}

	public Product(String name, String brand, int price) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", brand=" + brand + ", price=" + price
				+ ", category=" + category + "]";
	}

	

}
