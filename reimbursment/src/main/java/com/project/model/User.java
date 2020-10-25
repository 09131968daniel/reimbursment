package com.project.model;

import java.util.List;

public class User {
private int userId;
private String username;
private String password;
private String firstName;
private String lastName;
private String email;
private String user_role;
private int user_role_id;



public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getuser_role() {
	return user_role;
}
public void setuser_role(String user_role) {
	this.user_role = user_role;
}

public int getuser_role_id() {
	return user_role_id;
}
public void setuser_role_id(int user_role_id) {
	this.user_role_id = user_role_id;
}
public User(String username, String password, String firstName, String lastName, String email, int user_role_id) {
	
	super();
	this.username = username;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.user_role_id =user_role_id;
	if (this.user_role_id==1) {
		this.user_role="finance manager";
	}
	else {
		this.user_role="employee";
	}
}
	
	public User( int userId,String username, String firstName, String lastName, int user_role_id, String userRole) {
		
		super();
		this.userId=userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.user_role_id =user_role_id;
	    this.user_role=userRole;
	    }  
	    public User(int userId) {
	    	super();
	    	this.userId=userId;
	    }
	    
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", user_role=" + user_role
				+ ", user_role_id=" + user_role_id + "]";
	}




}
