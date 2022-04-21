package com.qa.baespring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.baespring.domain.User;
import com.qa.baespring.service.UserService;

@RestController
@CrossOrigin //requests can come from anywhere
@RequestMapping("/user")
public class UserController {
	
	private UserService service;
	
	public UserController(UserService service) {
		super();
		this.service = service;
	}


	// Get
	@GetMapping("/getById/{id}") // localhost:8080/user/getById
	public ResponseEntity<User> getById (@PathVariable long id) {
		return new ResponseEntity<User>(service.getById(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/getAll") // localhost:8080/user/getAll
	public ResponseEntity<List<User>>getAll() {
		return new ResponseEntity<List<User>>(service.getAll(),HttpStatus.OK);
		
		
	}
	
	//Get by Username(get one user)
	
	@GetMapping("getByUsername/{username}") // localhost:8080/user/getByUsername/username
	public ResponseEntity<User> getByUsername(@PathVariable String username) {
		return new ResponseEntity<User>(service.getByUsername(username), HttpStatus.OK);
	}
	
	//Get by age
	
	@GetMapping("getByAge/{age}") // localhost:8080/user/getByAge/age
	public ResponseEntity<List<User>> getByAge(@PathVariable int age) {
		return new ResponseEntity<List<User>>(service.getByAge(age), HttpStatus.OK);
	}
	
	
	// Post
	@PostMapping("/create") // localhost:8080/user/create
	public ResponseEntity<User>create(@RequestBody User myUser) {
		return new ResponseEntity<User>(service.create(myUser), HttpStatus.CREATED);
		
		
	}
	
	
	// Put
	@PutMapping("/update/{id}") // localhost:8080/user/update/id
	public ResponseEntity<User>update(@PathVariable long id, @RequestBody User myUser) {
		return new ResponseEntity<User>(service.update(id, myUser),HttpStatus.CREATED);
			
	}
	
	
	// Delete//using a turnary if
	@DeleteMapping("/delete/{id}") //localhost:8080/user/delete/id
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return (service.delete(id))? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) : 
			new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}



