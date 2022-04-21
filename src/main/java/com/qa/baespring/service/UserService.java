package com.qa.baespring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.baespring.domain.User;
import com.qa.baespring.repo.UserRepo;

@Service
public class UserService {
	
	private UserRepo repo;

	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	// get by ID 
	public User getById(long id) {
		return repo.findById(id).get(); //.get will either get the user if exists or throw the exception no such element)
	} 
	
	
	//get ALL users
	public List<User>getAll(){
		return repo.findAll();
	}
	
	
	//get by username
		public User getByUsername(String username) {
			return repo.findByUsername(username).get();
	}
		
		
	//get by age
		public List<User> getByAge(int age) {
			return repo.findByAge(age);
	}
	
		
	public User create(User myUser) {
		return repo.saveAndFlush(myUser);
	}
	
	//update a user
	
	public User update(long id, User myUser) {
		User existing = repo.findById(id).get(); // get the existing user
		existing.setFirstname(myUser.getFirstname()); // change the users first name to new user firstname
		existing.setLastname(myUser.getLastname()); // change existing user last name to new user last name
		existing.setUsername(myUser.getUsername()); // change existing user username to new user username
		existing.setAge(myUser.getAge()); // change
		return repo.saveAndFlush(existing);
	
	}
	
	//Delete a user
	public boolean delete(long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}

}


