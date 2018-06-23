package com.ts.web;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.ts.dao.RegisterDAO;
import com.ts.dto.Student;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private Connection con = null;
	private PreparedStatement pst = null;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		String rollNumber = request.getParameter("rollNumber");
		String password = request.getParameter("password");
		Student student=new Student();
		student.setPassword(password);
		student.setRollNumber(rollNumber);
		int x = new RegisterDAO().editPassword(student);
		if(x > 0) {
			JOptionPane.showMessageDialog(null, "changed successfully!!!!!");
			RequestDispatcher rd = request.getRequestDispatcher("sbSearch.jsp");
			rd.include(request, response);			
		}
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);	
	}
}