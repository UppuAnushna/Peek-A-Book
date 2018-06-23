package com.ts.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.RegisterDAO;
import com.ts.dto.Student;


/**
 * Servlet implementation class DisplayAllBooks
 */
@WebServlet("/DisplayAllBooks")
public class DisplayAllBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterDAO dao=new RegisterDAO();
		List<Student> studentList=dao.getAllInfo();
		request.setAttribute("studentList", studentList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("displayAllBooks.jsp");
		dispatcher.include(request, response);	
		System.out.println("ANU");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
