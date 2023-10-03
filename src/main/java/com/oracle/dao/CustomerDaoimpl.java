package com.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.ActiveLoans;
import com.oracle.entity.Customer;

public class CustomerDaoimpl implements CustomerDao {

	@Override
	public List<Customer> getCustomerDetails() {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String sql="";
		try {
			PreparedStatement ps=con.prepareStatement(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public List<ActiveLoans> getLoanDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
