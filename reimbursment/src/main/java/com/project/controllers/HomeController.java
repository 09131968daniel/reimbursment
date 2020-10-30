package com.project.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.management.relation.Role;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.DAO.ReimbursmentDAOim;
import com.project.DAO.UserDAOim;
import com.project.model.Reimbursment;
import com.project.model.ReimbursmentStatus;
import com.project.model.ReimbursmentType;
import com.project.model.User;


public class HomeController {

	public static void getLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.print("inside home controller get login page");
		request.getRequestDispatcher("http://localhost:8080/Reimbursment/login.html");
		
	}

	public static void getFailedLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.sendRedirect("http://localhost:8080/Reimbursment/loginfailed.html");
		
	}


	@SuppressWarnings("unchecked")
	
	public static void getHomePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String feed1=(String)request.getSession().getAttribute("feed1");
		
		if(request.getSession(false)==null) {
			response.setStatus(403);
			response.sendRedirect("http://localhost:8080/Reimbursment/api");
			}
		else  {
			int role=(int)request.getSession().getAttribute("user_role_id");
			
			System.out.println(role);
			
			if (role==2)
				response.sendRedirect("http://localhost:8080/Reimbursment/employee.html");		
			else if (role==1)
				response.sendRedirect("http://localhost:8080/Reimbursment/managers.html");	
		}
	}
	
	


}




