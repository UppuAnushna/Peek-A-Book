package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.ts.dao.AdminDAO;

/**
 * Servlet implementation class RegisterLibraryBook
 */
@WebServlet("/RegisterLibraryBook")
public class RegisterLibraryBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("bookId"));
		String name = request.getParameter("bookName");
		String author = request.getParameter("author");
		AdminDAO dao = new AdminDAO();
		dao.insertBook(id,name,author);
		JOptionPane.showMessageDialog(null, "updated successfully");
		RequestDispatcher dispatcher=request.getRequestDispatcher("adminHomePage.jsp");	
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
