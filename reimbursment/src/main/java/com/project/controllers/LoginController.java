package com.project.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.DAO.UserDAOim;
import com.project.model.User;

public class LoginController {

	
	
	public static void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("I'm in login controller" );
		if (!request.getMethod().equals("POST"))  {
			System.out.println("That's a " + request.getMethod()+ " method, invalid method" );
			response.sendRedirect("http://localhost:8080/Reimbursment/api/");
		}
			else 
			{
				int ret=-1;	
				String username=request.getParameter("username");
				String password=request.getParameter("password");
					
				UserDAOim  ud= new UserDAOim();	
				ret= ud.LoginUser(username, password);
				  	
				//login found
				  if (ret>0)
				  {
					  User u=ud.getUserbyUsername(username);	  
					System.out.println(u.toString());
					  
					  HttpSession session=request.getSession();

					  session.setAttribute("user_username", username);
					  session.setAttribute("user_email", u.getEmail());
					  session.setAttribute("user_role_id", ret);
					  session.setAttribute("user_role", u.getUserrole().getUser_role());
					  session.setAttribute("user_first_name", u.getFirstName());
					  session.setAttribute("user_last_name", u.getLastName());
					  session.setAttribute("user_id", u.getUserId());
					 
					
					  
					  response.setStatus(300);					  
					  response.sendRedirect("http://localhost:8080/Reimbursment/api/home");
				  }

		 	else  {
				  response.sendRedirect("http://localhost:8080/Reimbursment/api/home/failedlogin");
				  }
			}
	}
	

	public static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		response.sendRedirect("http://localhost:8080/Reimbursment/login.html");
	}



	}

