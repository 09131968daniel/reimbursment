package com.project.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	System.out.println(request.getRequestURI());
	
	String s= request.getRequestURI();
	
	switch(s) { 
		
	case "/Reimbursment/api/login":
			System.out.println("i'm in requesthelper at /api/login");
			LoginController.login(request,response);
			break;
		
		case "/Reimbursment/api/logout":
			LoginController.logout(request,response);
			break;
		
		case "/Reimbursment/api/home/failedlogin":
			System.out.println("i'm in requesthelper at /api/home/failed/login");
			HomeController.getFailedLoginPage(request,response);
			break;
		
		case "/Reimbursment/api/home/register":
			System.out.println("i'm in requesthelper at /api/home/register");
			RegisterController.RegisterUser(request,response);
			break;
		
		case "/Reimbursment/api/home/insert_reimbursement":
			System.out.println("i'm in requesthelper at /api/home/insert_reimbursment");
			HomeController.insertReimbursment(request,response);
			break;
			
		case "/Reimbursment/api/home":
			HomeController.getHomePage(request,response);
			break;
		
		
		default:
			HomeController.getLoginPage(request,response);
			break;
	}
  }
}

	

