package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.model.ReimbursmentType;
import com.project.util.ConnectionFactory;

public class ReimbursmentTypeDAOim implements ReimbursmentTypeDAO {

	@Override
	public ReimbursmentType  getReimbursmentTypeByID(int id) {
		
		int reimb_type_id =-1;
		String reimb_type="";
		ReimbursmentType rt = null;
		
		
		Connection conn = ConnectionFactory.getConnection();
		String sql="select reimb_type_id,reimb_type from reimbursement.ers_reimbursement_type where reimb_type_id=(?)";
		
		try {
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			reimb_type_id = rs.getInt(1);
			reimb_type = rs.getString(2);
			rt =( new ReimbursmentType(reimb_type_id,reimb_type));
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rt ;
	}	
	

	@Override
	public ArrayList<ReimbursmentType> getReimbursmentTypeAll() {
		int reimb_type_id =-1;
		String reimb_type="";
		ArrayList<ReimbursmentType> rt= new ArrayList<ReimbursmentType>();
		
		Connection conn = ConnectionFactory.getConnection();
		String sql="select reimb_type_id,reimb_type from reimbursement.ers_reimbursement_type";
		try {
		PreparedStatement ps=conn.prepareStatement(sql);
		
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			reimb_type_id = rs.getInt(1);
			reimb_type = rs.getString(2);
			rt.add(new ReimbursmentType(reimb_type_id,reimb_type));
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rt ;
	}


}
