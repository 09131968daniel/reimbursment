package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.model.ReimbursmentStatus;
import com.project.model.UserRole;
import com.project.util.ConnectionFactory;

public class UserRoleDAOim implements UserRoleDAO {

	@Override
	public UserRole getUserRolebyId(int id) {
		int ers_user_role_id =-1;
		String user_role="";
		UserRole ur = null;
		
		
		Connection conn = ConnectionFactory.getConnection();
		String sql="select ers_user_role_id, user_role from reimbursement.ers_user_roles where ers_user_role_id=(?)";
		
		try {
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			ers_user_role_id = rs.getInt(1);
			user_role = rs.getString(2);
			ur =( new UserRole(ers_user_role_id,user_role));
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ur ;
	}

	@Override
	public ArrayList<UserRole> getUserRoleAll() {
		int ers_user_role_id =-1;
		String user_role="";
		
		ArrayList<UserRole> ur = new ArrayList<UserRole>();
		
		
		Connection conn = ConnectionFactory.getConnection();
		String sql="select ers_user_role_id, user_role from reimbursement.ers_user_roles";
		
		try {
		PreparedStatement ps=conn.prepareStatement(sql);
		
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			ers_user_role_id = rs.getInt(1);
			user_role = rs.getString(2);
			ur.add(new UserRole(ers_user_role_id,user_role));
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ur ;
	}

}
