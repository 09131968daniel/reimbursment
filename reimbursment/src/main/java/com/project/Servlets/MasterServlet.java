package com.project.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.controllers.RequestHelper;

/**
 * Servlet implementation class MasterServlet
 */
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MasterServlet() {
        super();
        }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestHelper.process(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doGet(request, response);
	}

}
