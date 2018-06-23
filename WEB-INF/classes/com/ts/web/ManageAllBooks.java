package com.ts.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.dao.RegisterDAO;
import com.ts.dto.Student;

/**
 * Servlet implementation class ManageAllBooks
 */
@WebServlet("/ManageAllBooks")
public class ManageAllBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterDAO dao=new RegisterDAO();
		HttpSession ss = request.getSession();
		String userName = (String)ss.getAttribute("loggedUser");
		List<Student> studentList=dao.getMyInfo(userName);
		System.out.println(studentList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("manageMyBooks.jsp");
		request.setAttribute("studentList", studentList);
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
