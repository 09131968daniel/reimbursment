package com.project.DAO;

import java.util.ArrayList;

import com.project.model.Reimbursment;

public interface ReimbursmentDAO {

int insertReimbursment(Reimbursment r);
ArrayList<Reimbursment> getReimbursmentAll();
ArrayList<Reimbursment> getReimbursmentByUserId(int id);
int updateReimbursmentById(int reimb_id,int  reimb_resolver_id, int reimb_status);
ArrayList<Reimbursment> getReimbursmentByStatus(int status_id);
}
