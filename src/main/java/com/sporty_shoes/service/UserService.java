package com.sporty_shoes.service;

import java.util.List;

import com.sporty_shoes.model.User;

public interface UserService {
	
	public User addUser(User user) ; 
	public User updateUser(User user) ; 
	public void deleteUser(int id) ; 
	
	public User getUserById(int id) ; 
	public List<User> getAllUser() ; 
	public List<User> getUserByFirstName(String firstname) ; 
	public List<User> getUserByLastName(String lastname) ; 
	public List<User> getUserByAge(int age) ; 
	public User getUserByEmail(String emailid) ; 

}
