package com.sporty_shoes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
public class User {
	
	@Id
	@TableGenerator(name="userGen", initialValue=3)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="userGen")
	private int userid ; 
	
	private String firstname ; 
	private String lastname ; 
	private int age ; 
	private String emailid ; 
	private String password ;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private List<Purchase> purchaselist = new ArrayList<>() ;
	
	public User() {
		
	}


	public User(String firstname, String lastname, int age, String emailid, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.emailid = emailid;
		this.password = password;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


//	public List<Purchase> getPurchaselist() {
//		return purchaselist;
//	}


	public void setPurchaselist(List<Purchase> purchaselist) {
		this.purchaselist = purchaselist;
	} 
	
	
	
}
