package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.model.User;
import com.project.util.ConnectionFactory;

public class UserDAOim implements UserDAO{

	@Override
	public void RegisterUser(User u) {
		
		Connection conn = ConnectionFactory.getConnection();
		String sql="insert into reimbursement.ers_users(\r\n" + 
				"ers_username,\r\n" + 
				"ers_password ,\r\n" + 
				"user_first_name ,\r\n" + 
				"user_last_name ,\r\n" + 
				"user_email,\r\n" + 
				"user_role_id\r\n" + 
				") VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
		PreparedStatement ps=conn.prepareStatement(sql);
		
		  ps.setString(1, u.getFirstName());
		  ps.setString(2, u.getLastName());
		  ps.setString(3, u.getEmail());
		  ps.setString(4, u.getUsername());
		  ps.setString(5, u.getPassword());
		  ps.setInt(6, u.getuser_role_id());
		  
		  boolean b=ps.execute();
		 
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}

	@Override
	public int LoginUser(String username, String password) {
		int id=-1 ;
		int user_role_id=-1;
		
		Connection conn = ConnectionFactory.getConnection();
		String sql="select u.ers_users_id, ers_user_role_id from  reimbursement.vw_users u where u.ers_username=(?) and u.ers_password=(?) ";
		try {
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			id=rs.getInt(1);
			user_role_id=rs.getInt(2);
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return user_role_id ;
	}



	

	@Override
	public int findUserbyUsername(String s) {
		int user_id=-1;
		
	
		Connection conn = ConnectionFactory.getConnection();
		
		String sql="select u.ers_users_id, u.ers_user_role_id from  reimbursement.vw_users u where u.ers_username=(?)";
		
		try {
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setString(1, s);

		ResultSet rs=ps.executeQuery();
		
		
		while(rs.next()){
			 user_id=rs.getInt(1);
		
		}
		
	
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	
		return user_id;
	}

	}


	


	
	


