package com.project.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.DAO.ReimbursmentDAOim;
import com.project.DAO.ReimbursmentStatusDAOim;
import com.project.DAO.ReimbursmentTypeDAOim;
import com.project.model.Reimbursment;
import com.project.model.ReimbursmentStatus;
import com.project.model.ReimbursmentType;
import com.project.model.User;

public class DataController {
	
	 public static void sendUserInfo( HttpServletRequest req,  HttpServletResponse res) {}
	/*
	 * User u = new User();
	 * 
	 * 
	 * session.getAttribute("user_username"); session.geAttribute("user_email");
	 * session.getAttribute("user_role_id"); session.getAttribute("user_role");
	 * session.getAttribute("user_first_name");
	 * session.getAttribute("user_last_name"); session.getAttribute("user_id");
	 * 
	 * res.setContentType("text/json"); ArrayList<ReimbursmentStatus>
	 * reimbursmentStatuses = rstatus.getReimbursementStatusAll(); try {
	 * res.getWriter().println(new
	 * ObjectMapper().writeValueAsString(reimbursmentStatuses)); } catch
	 * (IOException e) { } }
	 */

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
	
		 	res.setContentType("text/json");
		 	List<Reimbursment> reimbursment = r.getReimbursmentAll();
		 
		 	
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
			//	response.sendRedirect("http://localhost:8080/Reimbursment/api");
				}
			else  {
				
				double reimb_amount=Double.parseDouble(request.getParameter("reimb_amount"));
				int reimb_type_id=Integer.parseInt(request.getParameter("reimbtypeid"));
				String reimb_description =request.getParameter("reimb_description");
				int reimb_resolver_id =1;
				int reimb_status_id=Integer.parseInt(request.getParameter("reimbstatusid"));
				int reimb_author=(int)request.getSession().getAttribute("user_id");
				
				
				
				Reimbursment r= new Reimbursment(
						reimb_amount,
						new User(reimb_author),
						new User(reimb_resolver_id),
						reimb_description,
						new ReimbursmentStatus(reimb_status_id),
						new ReimbursmentType(reimb_type_id));
						
				ReimbursmentDAOim d =  new ReimbursmentDAOim();
				d.insertReimbursment(r);
				
				response.sendRedirect("http://localhost:8080/Reimbursment/employee.html");
				System.out.println("insert succesd:"+r.toString());
		}
	}
	 }

 