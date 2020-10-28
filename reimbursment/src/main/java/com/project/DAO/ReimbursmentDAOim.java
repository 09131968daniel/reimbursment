package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.model.User;



import com.project.model.Reimbursment;
import com.project.model.ReimbursmentStatus;
import com.project.model.ReimbursmentType;
import com.project.util.ConnectionFactory;

public class ReimbursmentDAOim implements ReimbursmentDAO {

	@Override
	public int insertReimbursment(Reimbursment r) {
		
		int ret=-1;
		
		Connection con = ConnectionFactory.getConnection();
		
		String sql="insert into reimbursement.ers_reimbursement( reimb_amount ,reimb_author , reimb_description  ,"
				+ "reimb_resolver ,reimb_status_id ,reimb_type_id )	values(?,?,?,?,?,?) returning reimb_id";
		
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
		 
		  Connection con = ConnectionFactory.getConnection();
	  
	  String  sql="select reimb_id,reimb_amount,reimb_submitted,coalesce(reimb_resolved,reimb_submitted) as reimb_submitted,reimb_author,author_name,reimb_resolver,resolver_name,trim(reimb_description), reimb_status_id,reimb_status,reimb_type_id,reimb_type from reimbursement.vw_reimbursement";
	  try {
	  PreparedStatement ps =con.prepareStatement(sql);
	  ResultSet rs=ps.executeQuery();
	  
	 
	  while (rs.next()) { 
	
	 ar.add(new Reimbursment(
		rs.getInt(1),
		rs.	getDouble(2),
		rs.getString(3),
		rs.getString(4), 
		new User(rs.getInt(5),rs.getString(6)),
	    new User(rs.getInt(7), rs.getString(8)),
	    rs.getString(9), 
		new ReimbursmentStatus(rs.getInt(10), rs.getString(11)),
		new ReimbursmentType(rs.getInt(12),rs.getString(13))
			 ));
	   }
	  } 
	  catch(SQLException e) {
		  e.printStackTrace();
		  }
	  return ar;
	  }
	 
	  @Override 
		 
	  public ArrayList<Reimbursment> getReimbursmentByUserId(int author_id) {
		  ArrayList<Reimbursment> ar = new ArrayList<Reimbursment>(); 
		 
		  Connection con = ConnectionFactory.getConnection();
	  
	  String  sql="select reimb_id,reimb_amount,reimb_submitted,coalesce(reimb_resolved,reimb_submitted) as reimb_submitted,reimb_author,author_name,reimb_resolver,resolver_name,trim(reimb_description),"
	  		+ " reimb_status_id,reimb_status,reimb_type_id,reimb_type from reimbursement.vw_reimbursement where reimb_author=(?)";
	  try {
	  
	  PreparedStatement ps =con.prepareStatement(sql);
	  
	  ps.setInt(1, author_id);
	  ResultSet rs=ps.executeQuery();
	  
	 
	  while (rs.next()) { 
	
	 ar.add(new Reimbursment(
		rs.getInt(1),
		rs.	getDouble(2),
		rs.getString(3),
		rs.getString(4), 
		new User(rs.getInt(5),rs.getString(6)),
	    new User(rs.getInt(7), rs.getString(8)),
	    rs.getString(9), 
		new ReimbursmentStatus(rs.getInt(10), rs.getString(11)),
		new ReimbursmentType(rs.getInt(12),rs.getString(13))
			 ));
	   }
	  } 
	  catch(SQLException e) {
		  e.printStackTrace();
		  }
	  return ar;
	  
	  }



	@Override
	public int updateReimbursmentById(int reimb_id,int reimb_resolver_id,int reimb_status_id) {
		boolean ret;
	
		Connection con = ConnectionFactory.getConnection();
		  
		  String  sql="update reimbursement.ers_reimbursement set reimb_status_id=(?) , reimb_resolver=(?), reimb_resolved=current_date  where reimb_id=(?)";
		  try {
		  
		  PreparedStatement ps =con.prepareStatement(sql);
		  
		  ps.setInt(1, reimb_status_id);
		  ps.setInt(2, reimb_resolver_id);
		  ps.setInt(3,reimb_id);
		  
		  ret=ps.execute();
		  }
		  	catch(SQLException e) {
		
		  			e.printStackTrace();
		  	}
		  
		return 0;
		  
	}	
}




