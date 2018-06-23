package com.ts.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import com.ts.dao.RegisterDAO;
import com.ts.dto.Student;


@WebServlet("/RegisterServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50, 
location = "/home/anu/eclipse-workspace/PeekABook/WebContent/images")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookName=request.getParameter("bookName");
		String rollNumber=request.getParameter("rollNumber");
		int edition = Integer.parseInt(request.getParameter("edition"));
		String author=request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		Part part = request.getPart("photo");
		String fileName = getFileName(part);
		part.write(fileName);
		Student student=new Student();
		student.setBookName(bookName);
		student.setRollNumber(rollNumber);
		student.setEdition(edition);
		student.setAuthor(author);
		student.setPrice(price);
		student.setPhoto(fileName);
		RegisterDAO registerDao=new RegisterDAO();
		if(registerDao.add(student)!=0){
			JOptionPane.showMessageDialog(null, "updated succesfully");
			RequestDispatcher dispatcher=request.getRequestDispatcher("sbSearch.jsp");
			dispatcher.include(request, response);
		}		
	}
	private String getFileName(Part part) {
		String content = part.getHeader("content-disposition");
		System.out.println("content-disposition :"+content);
 String fileName = content.substring(content.indexOf("filename") + 10, content.length() - 1);
 	int index = fileName.lastIndexOf("\\");
 	System.out.println("fileName:"+fileName.substring(index+1));
 return fileName.substring(index+1);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
