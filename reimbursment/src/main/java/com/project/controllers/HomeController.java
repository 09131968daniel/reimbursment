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

	public static void getLoginPage(HttpServletRequest request, HttpServletResponse response) {
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
			response.sendRedirect("http://localhost:8080/Reimbursment/api");}
		else  {
			int role=(int)request.getSession().getAttribute("user_role_id");
			
			System.out.println(role);
			
			if (role==1)
				response.sendRedirect("http://localhost:8080/Reimbursment/employee.html");		
			else if (role==2)
				response.sendRedirect("http://localhost:8080/Reimbursment/managers.html");	
		}
	}

	public static void insertReimbursment(HttpServletRequest request, HttpServletResponse response) {
		String feed1=(String)request.getSession().getAttribute("feed1");
		System.out.println("inside in insertReimbursment");
		
		if(request.getSession(false)==null) {
			response.setStatus(403);
		//	response.sendRedirect("http://localhost:8080/Reimbursment/api");
			}
		else  {
			
			double reimb_amount=Double.parseDouble(request.getParameter("reimb_amount"));
			int reimb_type_id=Integer.parseInt(request.getParameter("reimbtypeid"));
			String reimb_description =request.getParameter("reimb_description");
			int reimb_resolver_id =Integer.parseInt(request.getParameter("reimbresolverid"));
			int reimb_status_id=Integer.parseInt(request.getParameter("reimbstatusid"));
			int reimb_author=Integer.parseInt(request.getAttribute("user_id").toString());
			
			
			
			Reimbursment r= new Reimbursment(
					reimb_amount,
					new User(reimb_author),
					new User(reimb_resolver_id),
					reimb_description,
					new ReimbursmentStatus(reimb_status_id),
					new ReimbursmentType(reimb_type_id));
					
			ReimbursmentDAOim d =  new ReimbursmentDAOim();
			d.insertReimbursment(r);
			System.out.println("insert succesd:"+r.toString());
		
	}
}
}




