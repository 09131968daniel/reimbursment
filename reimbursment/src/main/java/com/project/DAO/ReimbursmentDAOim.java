package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		
		String sql="select reimb_id,reimb_amount,reimb_resolved,reimb_submitted, reimb_status_id,reimb_status,"
				+ "reimb_type_id,reimb_type,reimb_author,author_name,reimb_resolver,resolver_name,ers_user_role_id,"
				+ "user_role,reimb_description from reimbursement.vw_reimbursement";
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				 
				Reimbursment r= new Reimbursment();
				r.setReimb_id(rs.getInt(1));
				ar.add(r);
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return r;
	}

	@Override
	public int updateReimbursmentById(int id) 
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

}
