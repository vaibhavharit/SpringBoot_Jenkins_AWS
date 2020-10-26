package com.sporty_shoes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sporty_shoes.model.User;
import com.sporty_shoes.repository.UserRepository;
import com.sporty_shoes.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository ; 

	@Override
	public User addUser(User user) {
		try {
			User u = userRepository.save(user) ; 
			return u ; 
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to add User due to a bad request") ; 
		}
		
	}

	@Override
	public User updateUser(User user) {
		try {
			User u = userRepository.save(user) ; 
			return u ; 
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to update User due to a bad request") ; 
		}
	}

	@Override
	public void deleteUser(int id) {
		try {
			userRepository.deleteById(id);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found for the given ID", e) ; 
		}
		
	}

	@Override
	public User getUserById(int id) {
		
		try {
			User u = userRepository.findById(id).get() ;
			return u ; 
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found for the given ID") ; 
		}
	}
	
	

	@Override
	public List<User> getAllUser() {
		List<User> userList = userRepository.findAll() ; 
		
		if(userList.size()==0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are currently no users in the system") ; 
		}
		else {
			return userList ; 
		}
	}

	@Override
	public List<User> getUserByFirstName(String firstname) {
		
		List<User> userList = userRepository.findByFirstname(firstname) ; 
		
		if(userList.size()==0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are currently no users with the requested first name in the system") ; 
		}
		else {
			return userList ; 
		}
		
	}

	@Override
	public List<User> getUserByLastName(String lastname) {
		List<User> userList = userRepository.findByLastname(lastname) ; 

		if(userList.size()==0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are currently no users with the requested last name in the system") ; 
		}
		else {
			return userList ; 
		}
		
	}

	
	@Override
	public List<User> getUserByAge(int age) {
	
		List<User> userList = userRepository.findByAge(age) ; 
		
		if(userList.size()==0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are currently no users with the requested age in the system") ; 
		}
		else {
			return userList ; 
		}
		
	}

	
	@Override
	public User getUserByEmail(String emailid) {
			
			User user = userRepository.findByEmailid(emailid) ; 
			if(user==null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are currently no users with the requested emailID in the system") ; 
			}
			else {
				return user ; 
			}
	}

}
