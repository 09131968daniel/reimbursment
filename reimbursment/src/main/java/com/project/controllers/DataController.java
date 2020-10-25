package com.project.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.DAO.ReimbursmentDAOim;
import com.project.DAO.ReimbursmentStatusDAOim;
import com.project.DAO.ReimbursmentTypeDAOim;
import com.project.model.Reimbursment;
import com.project.model.ReimbursmentStatus;
import com.project.model.ReimbursmentType;

public class DataController {

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
	 
	 public static void sendReimbursments(HttpServletRequest req,  HttpServletResponse res) {
			
		 	ReimbursmentDAOim r =  new ReimbursmentDAOim();
	
		 	res.setContentType("text/json");
		 	ArrayList<Reimbursment> reimbursment = r.getReimbursmentAll();
		 	try {
		        res.getWriter().println(new ObjectMapper().writeValueAsString(reimbursment));
		 	}
		   catch(IOException e) {
		   }   
}
	 }

 