package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.UserDAOim;
import com.project.model.User;

public class RegisterController {
 
static public void  RegisterUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("im inside registerUser");
//employee role only registration
int user_role_id=2;

String first_name=request.getParameter("first_name") ; 
String  last_name=request.getParameter("last_name");
String email_address=request.getParameter("email_address"); 
String username=request.getParameter("username");
String  password=request.getParameter("password");
String  employee=request.getParameter("employee");
  
 UserDAOim ud= new UserDAOim();

// int ret_email =ud.findUserbyEmail(email_address);
int ret_username=ud.findUserbyUsername(username);

//System.out.println("is email for "+ret_email);
System.out.println("is username for: "+ ret_username);
  
if ( ret_username>0) {
	RequestDispatcher   red=request.getRequestDispatcher("/registerfailed.html");
	red.forward(request, response);
} else {

User u=new User(username, password, first_name, last_name, email_address, user_role_id); 
ud.RegisterUser(u);
 response.sendRedirect("http://localhost:8080/Reimbursment/login.html");

}
}
 }

 
 

