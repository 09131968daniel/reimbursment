package com.project.model;

public class User {
private int userId;
private String username;
private String password;
private String firstName;
private String lastName;
private String fullName;
private String email;
private UserRole userrole;


public User(String username, String password, String firstName, String lastName, String email, UserRole user_role) {
	
	super();
	this.username = username;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.fullName=firstName+" "+lastName;
	this.email = email;
	this.userrole=user_role;
	
}
	
	public User( int userId,String username, String firstName, String lastName, UserRole user_role ) {
		
		super();
		this.userId=userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName=firstName+" "+lastName;
		this.userrole=user_role;
		
	    }  
	public User( int userId,String username, String firstName, String lastName, UserRole user_role,String email ) {
		
		super();
		this.userId=userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName=firstName+" "+lastName;
		this.userrole=user_role;
		this.email = email;
	    }  	
public User(int userId) {
	    	super();
	    	this.userId=userId;
	    }
	    

	public User(int Id, String Name) {
			super();
			this.userId = Id;
			this.fullName = Name;
			this.firstName = "noset";
			this.lastName = "notset";
			this.userrole= new UserRole(2,"employee");
		    this.password = "notset";
		    this.username = "notset";
		    this.email = "notset";
		}
	


public UserRole getUserrole() {
	return userrole;
}



public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
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



public void setUser_role(UserRole user_role) {
	this.userrole = user_role;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", fullName=" + fullName + ", email=" + email + ", user_role=" + userrole
			+ "]";
}



}
