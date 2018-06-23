package com.ts.dao;


import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.ts.dbutility.*;
import com.ts.dto.Student;

public class RegisterDAO {
	public int add(Student student) {
		final String INSERT_QUERY="insert into saleBooks values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, student.getBookName());
			pst.setString(2, student.getRollNumber());
			pst.setInt(3, student.getEdition());
			pst.setString(4, student.getAuthor());
			pst.setInt(5,student.getPrice());
			pst.setString(6, student.getPhoto());
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public List<Student> getAllInfo(){
		List<Student> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
	final String SELECT_QUERY = "select rollNumber,phnNumber,name,email,bookName,edition,author,price,photo from students natural join saleBooks";
	try(Connection con = DBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		rst = pst.executeQuery();
		while(rst.next()){
			Student student=new Student();
			student.setRollNumber(rst.getString(1));
			student.setPhnNumber(rst.getInt(2));
			student.setName(rst.getString(3));
			student.setEmail(rst.getString(4));
			student.setBookName(rst.getString(5));
			student.setEdition(rst.getInt(6));
			student.setAuthor(rst.getString(7));
			student.setPrice(rst.getInt(8));
			student.setPhoto(rst.getString(9));
			list.add(student);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}
	public int editPassword(Student student) {
		Connection con = null;
		PreparedStatement pst = null;
		int x = 0;
			try {
				con = DBConnection.getConnection();
				pst = con.prepareStatement("update students set password=? where rollNumber = ?");
				pst.setString(1,student.getPassword());
				pst.setString(2,student.getRollNumber());			
				x = pst.executeUpdate();
				System.out.println("Inside Update....."+student);
			} catch (SQLException e) {				
				e.printStackTrace();
			}	
			finally{
				try {
					con.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			return x;
	}
	public Student getStudent(String rollNumber) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Student student=null;
	final String SELECT_QUERY = "select * from students where userName = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, rollNumber);
		rst = pst.executeQuery();
		if(rst.next()){
			 student=new Student();
			 student.setRollNumber(rst.getString(1));
			 student.setPhnNumber(rst.getInt(2));
			 student.setName(rst.getString(3));
			 student.setPassword(rst.getString(4));
			 student.setEmail(rst.getString(5));
			 
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return student;
	}
	public List<Student> getMyInfo(String userName) {
List<Student> list=new ArrayList<>();

		
		PreparedStatement pst = null;
		ResultSet rst = null;
	final String SELECT_QUERY = "select rollNumber,bookName,edition,author,price from students natural join saleBooks where rollNumber = ?";
	try(Connection con = DBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, userName);
		rst = pst.executeQuery();
		while(rst.next()){
			Student student=new Student();
			student.setRollNumber(rst.getString(1));
			student.setBookName(rst.getString(2));
			student.setEdition(rst.getInt(3));
			student.setAuthor(rst.getString(4));
			student.setPrice(rst.getInt(5));
			list.add(student);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
		
	}
	public int delete(String id,String name) {
		System.out.println("KEERTHI");
		int x = 0;
		final String DELETE_QUERY="delete  from saleBooks where rollNumber = ? and bookName = ?";
		PreparedStatement pst = null;
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(DELETE_QUERY);
			pst.setString(1,id);
			pst.setString(2, name);
			System.out.println(name);
			x = pst.executeUpdate();
			System.out.println("AFFU");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
}
