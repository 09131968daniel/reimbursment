package com.project.DAO;

import java.util.ArrayList;

import com.project.model.ReimbursmentStatus;

public interface ReimbursmentStatusDAO {
ReimbursmentStatus getReimbursmentStatusByID(int id);
ArrayList<ReimbursmentStatus> getReimbursementStatusAll();
}
 