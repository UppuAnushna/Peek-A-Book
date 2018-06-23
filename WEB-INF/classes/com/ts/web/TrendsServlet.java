package com.ts.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.LibraryDAO;
import com.ts.dto.Book;
import com.ts.dto.Student;

/**
 * Servlet implementation class TrendsServlet
 */
@WebServlet("/TrendsServlet")
public class TrendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ANU");
		LibraryDAO dao = new LibraryDAO();
		List<Book> trendList=dao.getTrends();
		RequestDispatcher dispatcher=request.getRequestDispatcher("Trends.jsp");
		request.setAttribute("trendList", trendList);
		System.out.println(trendList);
		dispatcher.forward(request, response);	
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
