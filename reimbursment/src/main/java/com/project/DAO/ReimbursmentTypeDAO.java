package com.project.DAO;

import java.util.ArrayList;

import com.project.model.Reimbursment;
import com.project.model.ReimbursmentType;

interface ReimbursmentTypeDAO {
	ReimbursmentType getReimbursmentTypeByID(int id);
	ArrayList<ReimbursmentType> getReimbursmentTypeAll();
	
}
