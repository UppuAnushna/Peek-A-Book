package com.ts.web;
import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("uname");
		String password=request.getParameter("psw");
		out.println("<html>");
		if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
RequestDispatcher dispatcher=request.getRequestDispatcher("adminHomePage.jsp");	
	dispatcher.forward(request, response);
		}
		else{
	out.println("<body> Invalid credentials.!</body>");
RequestDispatcher dispatcher=request.getRequestDispatcher("AdminLogin.html");
		dispatcher.include(request, response);		
		}
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}