package com.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.project.DAO.ReimbursmentDAOim;
import com.project.model.Reimbursment;

class TestReimbursmentDAO {



	

	@Test
	void testGetReimbursmentAll() {
		ReimbursmentDAOim rd=new ReimbursmentDAOim();
		ArrayList<Reimbursment> ar= rd.getReimbursmentAll();
		assertNotNull(ar);
	}
	

	@Test
	void testgetReimbursmentByUserId() {
		ReimbursmentDAOim rd=new ReimbursmentDAOim();
		ArrayList<Reimbursment> ar= rd.getReimbursmentByUserId(1);
		assertNotNull(ar);
	}
	

	@Test
	void testgetReimbursmentByStatus() {
		ReimbursmentDAOim rd=new ReimbursmentDAOim();
		ArrayList<Reimbursment> ar= rd.getReimbursmentByStatus(1);
		assertNotNull(ar);
	}
	}




