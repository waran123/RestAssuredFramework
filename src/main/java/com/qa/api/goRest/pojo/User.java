package com.qa.api.goRest.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;

public class User {
	
	/*"name":"mack",
	 "LastName" :"doobs",
	 "gender":"male", 
	 "email":"jack128@15ce.com", 
	 "status":"active"
	*/
	
	private String name ;
	private String LastName ; 
	private String gender;
	private String email ;
	private String status ; 
	
	//Create a Constructor to initialize the Variables : 
	
	public User(String name, String lastName, String gender, String email, String status) {
		this.name = name;
		this.LastName = lastName;
		this.gender = gender;
		this.email = email;
		this.status = status;
	}
	
	// Create Getter and Setter for accessing the private Variable 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
