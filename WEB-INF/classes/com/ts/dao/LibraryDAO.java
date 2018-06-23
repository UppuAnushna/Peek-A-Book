package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ts.dbutility.DBConnection;
import com.ts.dbutility.RDBConnection;
import com.ts.dto.Book;
import com.ts.dto.Student;
public class LibraryDAO {

	public List<Book> getAllInfo(String search) {
		List<Book> list=new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select bookName,author,available from books where bookName LIKE ? or author LIKE ?";
	try(Connection con = RDBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1,"%"+search+"%");
		pst.setString(2,"%"+search+"%");
		rst = pst.executeQuery();
		while(rst.next()){
			Book book =new Book();
			book.setBookName(rst.getString(1));
			book.setAuthor(rst.getString(2));
			book.setAvailable(rst.getInt(3));
			list.add(book);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}

	public List<com.ts.dto.Book> getTrends() {
		List<Book> list=new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select bookName,author,rating from books ORDER BY rating desc limit 3";
	try(Connection con = RDBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		rst = pst.executeQuery();
		while(rst.next()){
			Book book =new Book();
			book.setBookName(rst.getString(1));
			book.setAuthor(rst.getString(2));
			book.setRating(rst.getInt(3));
			list.add(book);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}

}
