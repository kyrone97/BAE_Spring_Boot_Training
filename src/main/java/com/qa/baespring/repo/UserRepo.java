package com.qa.baespring.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.baespring.domain.User;

@Repository
public interface UserRepo extends JpaRepository <User, Long > {
	
	Optional<User> findByUsername(String username);
	
	
	// a different way of doing query(have to write sql code for this version)
	@Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery=true)
	Optional<User> findByFirstname(String firstname);
	
	
	// get by age
	@Query(value = "SELECT * FROM user WHERE age = ?1", nativeQuery=true)
	 List<User> findByAge(int age);
	
	
}
