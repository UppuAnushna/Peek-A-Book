package com.ts.web;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.ts.dao.loginDAO;
/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("uname");
		String password=request.getParameter("psw");
		loginDAO loginDao = new loginDAO();
		HttpSession session=request.getSession();
		session.setAttribute("loggedUser", userName);
		out.println("<html>");
			try {
				if((loginDao.getPassword(userName)).equalsIgnoreCase(password)){
					RequestDispatcher dispatcher=request.getRequestDispatcher("sbSearch.jsp");	
					dispatcher.forward(request, response);
				} else{
					JOptionPane.showMessageDialog(null, "Please check your password!!!!!");
					RequestDispatcher dispatcher=request.getRequestDispatcher("Wise.html");	
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
