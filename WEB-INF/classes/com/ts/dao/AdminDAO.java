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

public class AdminDAO {

	public void insertBook(int id, String name,String author) {
		List<Book> list= getAllBooks();
		Book book = new Book();
		book.setBookName(name);
		book.setAuthor(author);
		boolean flag = true;
		System.out.println(list);
		System.out.println(book);
		System.out.println(list.contains(book));
		for(Book a:list) {
			if((a.getBookName()).equals(name) && (a.getAuthor()).equals(author)) {
				flag = false;
			System.out.println("JUIK");
			final String INSERT_QUERY="update books set available = ? where bookName = ? and author=?";
			PreparedStatement pst = null;
			int available = getAvailable(name,author);
			try(Connection con=RDBConnection.getConnection();) {
				pst=con.prepareStatement(INSERT_QUERY);
				pst.setInt(1,available+1);
				pst.setString(2,name);
				pst.setString(3, author);
				pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		}   if(flag == true) {
			System.out.println("keerthi");
			final String INSERT_QUERY="insert into books values(?,?,?)";
			PreparedStatement pst = null;
			
			
			try(Connection con=RDBConnection.getConnection();) {
				pst=con.prepareStatement(INSERT_QUERY);
				pst.setString(1,name);
				pst.setString(2, author);
				pst.setInt(3, 1);
				pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
			final String INSERT_QUERY="insert into booksInfo values(?,?,?)";
			PreparedStatement pst = null;
			
			
			try(Connection con=RDBConnection.getConnection();) {
				pst=con.prepareStatement(INSERT_QUERY);
				pst.setInt(1,id);
				pst.setString(2,name);
				pst.setString(3, author);
				pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
	}
		private int getAvailable(String name, String author) {
			int available = 0;
			PreparedStatement pst = null;
			ResultSet rst = null;
		final String SELECT_QUERY = "select available from books where bookName=? and author = ?";
		try(Connection con = RDBConnection.getConnection();){
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1,name);
			pst.setString(2,author);
			rst = pst.executeQuery();
			if(rst.next()){
			available = rst.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return available;
			
		}
		private int getRating(String name, String author) {
			int available = 0;
			PreparedStatement pst = null;
			ResultSet rst = null;
		final String SELECT_QUERY = "select rating from books where bookName=? and author = ?";
		try(Connection con = RDBConnection.getConnection();){
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1,name);
			pst.setString(2,author);
			rst = pst.executeQuery();
			if(rst.next()){
			available = rst.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return available;
			
		}
		public List<Book> getAllBooks() {
			List<Book> list=new ArrayList<>();

					
					PreparedStatement pst = null;
					ResultSet rst = null;
				final String SELECT_QUERY = "select bookName,author from books";
				try(Connection con = RDBConnection.getConnection();){
					pst = con.prepareStatement(SELECT_QUERY);
					rst = pst.executeQuery();
					while(rst.next()){
						Book book=new Book();
						book.setBookName(rst.getString(1));
						book.setAuthor(rst.getString(2));
						list.add(book);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
					
				}
		public void deleteBook(int id) {
			final String DELETE_QUERY="delete  from booksInfo where bookId = ?";
			PreparedStatement pst = null;
			try(Connection con=RDBConnection.getConnection();) {
				pst=con.prepareStatement(DELETE_QUERY);
				pst.setInt(1,id);
				pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			PreparedStatement psm= null;
			ResultSet rst = null;
			String name = null;
			String author = null;
		final String SELECT_QUERY = "select bookName,author from books where bookId = ?";
		try(Connection con = RDBConnection.getConnection();){
			psm = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			psm.setInt(1,id);
			if(rst.next()){
				name = rst.getString(1);
				author = rst.getString(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			final String INSERT_QUERY="update books set available = ?,rating = ? where bookName = ? and author=?";
			PreparedStatement psg = null;
			int available = getAvailable(name,author);
			int rating = getRating(name,author);
			try(Connection con=RDBConnection.getConnection();) {
				psg=con.prepareStatement(INSERT_QUERY);
				psg.setInt(1,available-1);
				psg.setInt(2,rating+1);
				psg.setString(3,name);
				psg.setString(4, author);
				psg.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			

	
}
