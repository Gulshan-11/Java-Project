package com.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.oracle.entity.ActiveLoans;
import com.oracle.entity.Application;
import com.oracle.entity.Customer;
@Component
public class ClerkDaoImpl implements ClerkDao {

	
	@Override
	public List<Application> getAllApplications() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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

	@Override
	public ActiveLoans getLoanDetailsById(int loanId) {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		ActiveLoans obj=null;
		//String sql="select * from activeloans where customerId=?";
		try {
		
				String sql="select * from activeloans where loan_id=?";
				PreparedStatement ps =con.prepareStatement(sql);
				ps.setInt(1, loanId);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					obj=new ActiveLoans();
					obj.setAmountPaid(rs.getLong("amount_paid"));
					obj.setAmountSanctioned(rs.getLong("amount_sanctioned"));
					obj.setApproverName(rs.getString("approver_name"));
					obj.setDate(rs.getDate("start_date"));
					obj.setEmisPaid(rs.getInt("emis_paid"));
					obj.setLoanId(rs.getLong("loan_id"));
					obj.setProgrameName(rs.getString("programe_name"));
					obj.setRoi(rs.getFloat("roi"));
					obj.setTenure(rs.getInt("tenure"));
					obj.setType(rs.getString("loan_type"));
					obj.setLoan_status(rs.getInt("loan_status"));
					
				}
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;

	}

	@Override
	public List<ActiveLoans> getLoanDetails() {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		List<ActiveLoans> loans=new ArrayList<>();
		//String sql="select * from activeloans";
		try {
		
			String sql="select * from activeloans";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ActiveLoans obj=new ActiveLoans();
				obj.setAmountPaid(rs.getLong("amount_paid"));
				obj.setAmountSanctioned(rs.getLong("amount_sanctioned"));
				obj.setApproverName(rs.getString("approver_name"));
				obj.setDate(rs.getDate("start_date"));
				obj.setEmisPaid(rs.getInt("emis_paid"));
				obj.setLoanId(rs.getLong("loan_id"));
				obj.setProgrameName(rs.getString("programe_name"));
				obj.setRoi(rs.getFloat("roi"));
				obj.setTenure(rs.getInt("tenure"));
				obj.setType(rs.getString("loan_type"));
				obj.setLoan_status(rs.getInt("loan_status"));
				loans.add(obj);
				
			}
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loans;
	}
	

}
