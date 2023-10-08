package com.oracle.secure.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.oracle.dao.DBConnection;
@Component
public class CheckUser {
	public boolean check(String userName) {
		DBConnection db=new DBConnection();
		Connection con=db.connect();
		String sql="select * from userdetails where username=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs=ps.executeQuery();
			if(rs.next())return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
		
	}
}
