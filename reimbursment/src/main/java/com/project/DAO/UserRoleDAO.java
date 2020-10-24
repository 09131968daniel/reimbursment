package com.project.DAO;

import java.util.ArrayList;

import com.project.model.UserRole;

public interface UserRoleDAO {
UserRole getUserRolebyId(int role_id);
ArrayList<UserRole> getUserRoleAll();
}
