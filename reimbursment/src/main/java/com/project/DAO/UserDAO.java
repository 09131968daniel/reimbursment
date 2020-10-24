package com.project.DAO;

import java.util.ArrayList;

import com.project.model.User;

public interface UserDAO {

	public void RegisterUser(User u);
	public int LoginUser(String username, String password);
	public int findUserbyUsername(String s);
 
}