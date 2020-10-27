package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.jni.User;

import com.project.model.Reimbursment;
import com.project.util.ConnectionFactory;

public class ReimbursmentDAOim implements ReimbursmentDAO {

	@Override
	public int insertReimbursment(Reimbursment r) {
		
		int ret=-1;
		
		Connection con = ConnectionFactory.getConnection();
		
		String sql="insert into reimbursement.ers_reimbursement( reimb_amount ,reimb_author , reimb_description  ,reimb_resolver ,reimb_status_id ,reimb_type_id )	values(?,?,?,?,?,?) returning reimb_id";
		
				try {
			PreparedStatement ps =con.prepareStatement(sql);
			
			ps.setDouble(1, r.getReimb_amount());
			ps.setInt(2, r.getReimb_author().getUserId());
			ps.setString(3, r.getReimb_description());
			ps.setInt(4, r.getReimb_resolver().getUserId());
			ps.setInt(5, r.getStatus().getReimb_status_id() );
			ps.setInt(6, r.getType().getReimb_type_id());
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				ret=rs.getInt(1);
			
			
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return ret;
	}
	
	  @Override 
	 
	  public ArrayList<Reimbursment> getReimbursmentAll() {
		  ArrayList<Reimbursment> ar = new ArrayList<Reimbursment>(); 
		  Reimbursment r=null;
		  Connection con = ConnectionFactory.getConnection();
	  
	  String  sql="select reimb_id,reimb_amount,reimb_resolved,reimb_submitted, reimb_status_id,reimb_status,"
	  +"reimb_type_id,reimb_type,reimb_author,author_name,reimb_resolver,resolver_name, reimb_description from reimbursement.vw_reimbursement";
	  try {
	  PreparedStatement ps =con.prepareStatement(sql); ResultSet
	  rs=ps.executeQuery();
	  
	  while (rs.next()) { 
	User u=  new User( "fdfdfd",1);
	 ar.add(new Reimbursment(
		rs.getInt(1),  //reimb_id
		rs.	getDouble(2), //reimb_amount
		rs.getString(3),  //reimb resolved
		rs.getString(4),  // reimb_submitted
	    new User(rs.getInt(9), rs.getString(10)),  //reimb_auth_name
		new User(rs.getInt(5),rs.getString(6)), //reimb status
		rs.getInt(7),  //reimb_type_id
		rs.getString(8),  //reimb_type

		rs.getInt(11),  //resolver_id
		rs.getString(12),  //resolver_name
		rs.getString(13) //reimb_description
			 ));
	   }
	  } 
	  catch(SQLException e) {
		  e.printStackTrace();
		  }
	  return r;
	  }
	 

	//@Override
/*	public int updateReimbursmentById(int id) {
		ArrayList<Reimbursment> r = new ArrayList<Reimbursment>();
	
		Connection con = ConnectionFactory.getConnection();
	
		String sql="";
	try {
		PreparedStatement ps =con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			r.add(null);
		}
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
*/
}
