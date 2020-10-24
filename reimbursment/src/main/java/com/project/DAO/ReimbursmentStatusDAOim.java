package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.model.ReimbursmentStatus;
import com.project.util.ConnectionFactory;

public class ReimbursmentStatusDAOim implements ReimbursmentStatusDAO{

	@Override
	public ReimbursmentStatus getReimbursmentStatusByID(int id) {
		
		int reimb_status_id =-1;
		String reimb_status="";
		ReimbursmentStatus rstatus = null;
		
		
		Connection conn = ConnectionFactory.getConnection();
		String sql="select reimb_status_id,reimb_status from reimbursement.ers_reimbursement_status where reimb_status_id=(?)";
		
		try {
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			reimb_status_id = rs.getInt(1);
			reimb_status = rs.getString(2);
			rstatus =( new ReimbursmentStatus(reimb_status_id,reimb_status));
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rstatus ;
	}

	@Override
	public ArrayList<ReimbursmentStatus> getReimbursementStatusAll() {
		int reimb_status_id =-1;
		String reimb_status="";
		ArrayList<ReimbursmentStatus> rstatus = new ArrayList<ReimbursmentStatus>();
		
		
		Connection conn = ConnectionFactory.getConnection();
		String sql="select reimb_status_id,reimb_status from reimbursement.ers_reimbursement_status";
		
		try {
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			reimb_status_id = rs.getInt(1);
			reimb_status = rs.getString(2);
			rstatus.add( new ReimbursmentStatus(reimb_status_id,reimb_status));
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rstatus ;
	}

}
