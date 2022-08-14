package com.codingdojo.serene.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {

	 @NotEmpty(message="Required!")
	 @Email(message="Enter a valid email!")
	 private String email;
	 
	 @NotEmpty(message="Required!")
	 @Size(min=5, message="Password must be above 5 characters")
	 private String password;
	 
	 public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	} 
}
