package com.sporty_shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sporty_shoes.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public List<User> findByFirstname(String firstname) ; 
	public List<User> findByLastname(String lastname) ; 
	public List<User> findByAge(int age) ; 
	public User findByEmailid(String emailid) ; 
	
}
	
