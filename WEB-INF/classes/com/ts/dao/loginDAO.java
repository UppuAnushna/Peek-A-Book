package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ts.dbutility.DBConnection;



public class loginDAO {
	public String getPassword(String userName) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rst = null;
		String requiredPassword = null; 
		final String SELECT_QUERY = "select * from students where rollNumber = ?";
		try(Connection con = DBConnection.getConnection();){
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, userName);
			rst = pst.executeQuery();
			if(rst.next()){
				requiredPassword = rst.getString(4);
			}
		}
		return requiredPassword;
	}
}
