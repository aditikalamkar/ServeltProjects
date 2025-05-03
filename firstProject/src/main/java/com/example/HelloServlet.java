package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request , HttpServletResponse
			response) throws ServletException , IOException{
		String name = request.getParameter("username");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h2>Hello," +name +"!<h2>");
		out.println("</html></body>");
		
	}

	
}
