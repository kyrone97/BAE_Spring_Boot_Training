package com.qa.baespring.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//used for modelling data into tables(maps from java/spring into database tables)
//will create the table in the database if it does not already exist
@Entity
public class User {
//	This makes the column a primary key
	@Id
//	This makes the column auto increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// Creates a column called "firstname"
	@Column(name = "firstname", nullable = false)
	private String firstname;
	
	// Creates a column called "last_name"
	@Column(name = "lastname", nullable = false)
	private String lastname;
	
	//Creates a column called "age"
	@Column(name = "age", nullable = false)
	private int age;
	
	// Creates a column called "username"
	// This column CAN NOT be null
	@Column(unique = true, nullable = false, name = "username")
	private String username;

	// Default Constructor
	public User() {}
	
	
	

	// Used for creating/inserting
	public User(String firstname, String lastname, String username, int age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.age = age;
	}

	// Used for reading/selecting (and testing)
	public User(long id, String firstname, String lastname, String username, int age) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.age = age;
	}




	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}






	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", username="
				+ username + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(age, firstname, id, lastname, username);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return age == other.age && Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(lastname, other.lastname) && Objects.equals(username, other.username);
	}



	
	

}
