package com.ts.web;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.LibraryDAO;
import com.ts.dao.RegisterDAO;
import com.ts.dto.Student;
/**
 * Servlet implementation class DisplayLibraryBooks
 */
@WebServlet("/DisplayLibraryBooks")
public class DisplayLibraryBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		LibraryDAO dao=new LibraryDAO();
		List<com.ts.dto.Book> bookList=dao.getAllInfo(search);
		RequestDispatcher dispatcher=request.getRequestDispatcher("displayLibraryBooks.jsp");
		request.setAttribute("bookList", bookList);
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
