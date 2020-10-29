package com.project.controllers;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.DAO.ReimbursmentDAO;
import com.project.DAO.ReimbursmentDAOim;
import com.project.DAO.ReimbursmentStatusDAOim;
import com.project.DAO.ReimbursmentTypeDAOim;
import com.project.model.Reimbursment;
import com.project.model.ReimbursmentStatus;
import com.project.model.ReimbursmentType;
import com.project.model.User;
import com.project.model.UserRole;

public class DataController {
	
	public static void updateReimbursmentById( HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("i'm in datacontroller updateReimbursment");
		
		int resolver_id=(int)(req.getSession().getAttribute("user_id"));
		int reimb_status_id=Integer.parseInt(req.getParameter("reimb_status_id"));
		int reimb_id=Integer.parseInt(req.getParameter("reimb_id"));
		String user_role = (String)req.getSession().getAttribute("user_role");
		
		ReimbursmentDAO d = new ReimbursmentDAOim();
		d.updateReimbursmentById(reimb_id,resolver_id,reimb_status_id);
		
		if (user_role.equals("finance manager")){
			res.sendRedirect("http://localhost:8080/Reimbursment/managers.html");
		}else
		{
			res.sendRedirect("http://localhost:8080/Reimbursment/employee.html");
		}
	}
	
	 public static void sendUserInfo( HttpServletRequest req,  HttpServletResponse res) throws JsonProcessingException, IOException {
	System.out.print("inside data controller userinfo");
		
		 int user_id=(int)req.getSession().getAttribute("user_id");
		 String user_role=(String)req.getSession().getAttribute("user_role"); 
		 String username=(String) req.getSession().getAttribute("user_username");
		 String email=(String)req.getSession().getAttribute("user_email");
		 String fname=(String)req.getSession().getAttribute("user_first_name");
		 String lname=(String)req.getSession().getAttribute("user_last_name");
	  
	  
	  res.setContentType("text/json");

	  User u= new User(username, "notset", fname, lname, email, new UserRole(0,"notset"));
	  System.out.print(u.toString());
	
	
		  res.getWriter().println(new ObjectMapper().writeValueAsString(u));
	 
	  }
	 

	 public static void sendReimbursmentStatus( HttpServletRequest req,  HttpServletResponse res) {
	
		 	ReimbursmentStatusDAOim rstatus =  new ReimbursmentStatusDAOim();
	
		 	res.setContentType("text/json");
		 	ArrayList<ReimbursmentStatus> reimbursmentStatuses = rstatus.getReimbursementStatusAll();
		 	try {
		        res.getWriter().println(new ObjectMapper().writeValueAsString(reimbursmentStatuses));
		 	} catch (IOException e) {
		    }
	}
	 
	 public static void sendReimbursmentTypes( HttpServletRequest req,  HttpServletResponse res) {
			
		 	ReimbursmentTypeDAOim rtypes =  new ReimbursmentTypeDAOim();
	
		 	res.setContentType("text/json");
		 	ArrayList<ReimbursmentType> reimbursmentTypes = rtypes.getReimbursmentTypeAll();
		 	try {
		        res.getWriter().println(new ObjectMapper().writeValueAsString(reimbursmentTypes));
		 	} catch (IOException e) {
		    }
	}
	 
	 public static void sendReimbursments(HttpServletRequest req,  HttpServletResponse res) throws JsonProcessingException, IOException {
			System.out.print("inside reimbursments data controller");
		 	ReimbursmentDAOim r =  new ReimbursmentDAOim();
		 	List<Reimbursment> reimbursment=null;
		 	
		 	int user_id=(int)req.getSession().getAttribute("user_id");
		 	String user_role=(String)req.getSession().getAttribute("user_role");
		 	
		 	res.setContentType("text/json");
		 	
		 	System.out.print("user_role: "+ user_role);
		 	if (user_role.equals("finance manager")) {
		 		reimbursment = r.getReimbursmentAll();
		 		
		 		System.out.print("executed for finance manager role");
		 	}
		 	else {
		 		System.out.print("executed for employee");
		 		 reimbursment = r.getReimbursmentByUserId(user_id);
		 	}
		 	
		 	
		 
		 	
		 	System.out.print(reimbursment.toString());
		 	ObjectMapper om = new ObjectMapper();
		 	
		        res.getWriter().write(om.writeValueAsString(reimbursment));
	 }
	 
		public static void insertReimbursment(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String feed1=(String)request.getSession().getAttribute("feed1");
			System.out.println("inside in insertReimbursment");
			System.out.println(Integer.parseInt(request.getParameter("reimbstatusid")));
			
			if(request.getSession(false)==null) {
			   response.setStatus(403);
			   response.sendRedirect("http://localhost:8080/Reimbursment/login.html");
				}
			else  {
				
				double reimb_amount=Double.parseDouble(request.getParameter("reimb_amount"));
				int reimb_type_id=Integer.parseInt(request.getParameter("reimbtypeid"));
				String reimb_description =request.getParameter("reimb_description");
				int reimb_resolver_id =1;
				int reimb_status_id=Integer.parseInt(request.getParameter("reimbstatusid"));
				int reimb_author=(int)request.getSession().getAttribute("user_id");
				String user_role=(String)request.getSession().getAttribute("user_role");
				
				
				Reimbursment r= new Reimbursment(
						reimb_amount,
						new User(reimb_author),
						new User(reimb_resolver_id),
						reimb_description,
						new ReimbursmentStatus(reimb_status_id),
						new ReimbursmentType(reimb_type_id));
						
				ReimbursmentDAOim d =  new ReimbursmentDAOim();
				
				d.insertReimbursment(r);
				
				if (user_role.equals("finance manager")) {
					System.out.println("user role:"+user_role +"insert succesd: "+r.toString());
					response.sendRedirect("http://localhost:8080/Reimbursment/managers.html");
				}else {
					System.out.println("user role:"+user_role +"insert succesd: "+r.toString());
					response.sendRedirect("http://localhost:8080/Reimbursment/employee.html");
		}
	}
	 }

		public static void sendReimbursmentsByStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
			System.out.print("inside reimbursmentsBydata controller");
		 	ReimbursmentDAOim r =  new ReimbursmentDAOim();
		 	List<Reimbursment> reimbursment=null;
		 	int status_id=Integer.parseInt(request.getParameter("status_id"));
		 
		 	response.setContentType("text/json");
		 	
		 	
		 		reimbursment = r.getReimbursmentByStatus(status_id);
		 		
		
		 	
		 
		 	
		 	System.out.print(reimbursment.toString());
		 	ObjectMapper om = new ObjectMapper();
		 	
		 	response.getWriter().write(om.writeValueAsString(reimbursment));
			
		}
}

 