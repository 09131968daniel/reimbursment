package com.project.DAO;

import java.util.ArrayList;

import com.project.model.Reimbursment;

public interface ReimbursmentDAO {
int insertReimbursment(Reimbursment r);
ArrayList<Reimbursment> getReimbursmentAll();
int updateReimbursmentById(int id);
}
