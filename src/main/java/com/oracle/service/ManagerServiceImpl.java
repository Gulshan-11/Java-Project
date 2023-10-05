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
@Component
public class ManagerServiceImpl implements ManagerService {

	public List<Application> getAllApplication() {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String sql="select * from loanapplication ";
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
	// 0 ->reject
	// 1->accept
	// 2->pending
public boolean approveLoan(String username,String applyid) {
	DBConnection dbcon=new DBConnection();
	Connection con=dbcon.connect();
	String sql="update loanapplication set Application_status=1 where application_id=? ";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, applyid);
		ps.executeUpdate();
		System.out.println("updated application");
		sql="select first_name from employeedetails where username=?";
		ps=con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs=ps.executeQuery();
        rs.next();
        String managerName=rs.getString("first_name");
        System.out.println("feteched first name");
        System.out.println("apply id"+ applyid);
		sql="select * from loanapplication where application_id=? ";
		ps=con.prepareStatement(sql);
		ps.setString(1,applyid);
	     rs=ps.executeQuery();
	     System.out.println("loan applicaion executed");
	    
		if(rs.next()) {
			sql="insert into activeloans values(?,?,?,?,SYSDATE,?,loanidSeq.nextval,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,rs.getString("customer_id"));
			ps.setInt(2, 0);
			ps.setInt(3, rs.getInt("amount_requested"));
			ps.setString(4, managerName);
			ps.setInt(5,0);			
			ps.setString(6,rs.getString("program_name"));
			ps.setFloat(7,rs.getFloat("roi"));
			ps.setInt(8,rs.getInt("tenure"));
			ps.setString(9,rs.getString("loan_type"));
	        ps.executeUpdate();	
	        System.out.println("inserted into activeloans");
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
return true;	
}
@Override
public boolean reject(String userName, String applyid)  {
	// TODO Auto-generated method stub
	DBConnection dbcon=new DBConnection();
	Connection con=dbcon.connect();
	String sql="update loanapplication set Application_status=0 where application_id=? ";
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, applyid);
		ps.executeUpdate();
		System.out.println("updated application");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return true;
}
	

}
