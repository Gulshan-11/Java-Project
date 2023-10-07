package com.oracle.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.oracle.dao.DBConnection;
import com.oracle.entity.Application;
import com.oracle.entity.Customer;
@Component
public class ClerkServiceImpl implements ClerkService {


	public List<Application> getAllApplications() {
        
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String sql="select * from loanapplication";
		List<Application> applicationData=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Application obj=new Application();
				obj.setApplicationId(rs.getString("application_id"));
				obj.setLoanType(rs.getString("loan_type"));
				obj.setProgramName(rs.getString("program_name"));
				obj.setApplicationStatus(rs.getInt("Application_status"));
				obj.setAmountRequested(rs.getInt("amount_requested"));
				obj.setApplicationDate(rs.getDate("application_date"));
				obj.setRejectReason(rs.getString("reject_reason"));
				obj.setRoi(rs.getFloat("roi"));
				obj.setTenure(rs.getInt("tenure"));
				applicationData.add(obj);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return applicationData;
	}

	@Override
	public Customer getgetCustomerDetailsById(String CustomerId) {
	
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String sql="select * from customerdetails where customer_id=?";
		Customer custData=null;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, CustomerId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				custData=new Customer();
				custData.setFirstName(rs.getString("first_name"));
				custData.setLastName(rs.getString("last_name"));
				custData.setDob(rs.getDate("dob"));
				custData.setEmail(rs.getString("email_id"));
				custData.setPhoneNo(rs.getLong("phone_no"));
				custData.setOccupation(rs.getString("occupation"));
				custData.setEmp_type(rs.getString("emp_type"));
				custData.setGender(rs.getString("gender"));
				custData.setIncome(rs.getLong("income"));
				custData.setCreditScore(rs.getInt("credit_score"));
				custData.setRegDate(rs.getDate("registered_date"));
				custData.setAccountStatus(rs.getString("account_status"));
				custData.setAddress(rs.getString("address"));
				custData.setCity(rs.getString("city"));
				custData.setState(rs.getString("state_name"));
				custData.setCountry(rs.getString("country"));
				custData.setPincode(rs.getInt("pincode"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return custData;

	}

}
