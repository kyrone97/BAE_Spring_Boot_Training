package com.qa.baespring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.baespring.domain.User;
import com.qa.baespring.service.UserService;

@RestController
public class UserController {
	
	private UserService service;
	
	public UserController(UserService service) {
		super();
		this.service = service;
	}


	// Get
	@GetMapping("/getById/{id}") // localhost:8080/getById
	public User getById (@PathVariable long id) {
		
		return service.getById(id);
	}
	
	
	
	
	
	// Post
	
	
	
	
	// Put/Patch
	
	
	
	
	
	// Delete
	
	
	
	
	

}