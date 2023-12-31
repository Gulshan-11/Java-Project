package com.oracle.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.oracle.dao.DBConnection;
import com.oracle.dao.ManagerDao;
import com.oracle.entity.Application;
import com.oracle.entity.Customer;
import com.oracle.entity.DocumentRetrievalData;
import com.oracle.entity.Nominee;
@Component
public class ManagerDaoImpl implements ManagerDao {

	@Override
	public List<Application> getAllApplication() {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String sql="select * from loanapplication where application_status!=3";
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
	public boolean approveLoan(String userName, String applyid) {
		// TODO Auto-generated method stub
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
			ps.setString(1, userName);
			ResultSet rs=ps.executeQuery();
	        rs.next();
	        String managerName=rs.getString("first_name");
	        System.out.println("feteched first name");
	       //String appId=new ObjectMapper().readValue(applyid, "String");
	 
	        System.out.println("apply id"+ applyid);
			sql="select * from loanapplication where application_id=? ";
			ps=con.prepareStatement(sql);
			ps.setString(1,applyid);
		     rs=ps.executeQuery();
		     System.out.println("loan applicaion executed");
		     
		     
			if(rs.next()) {
				int amount=rs.getInt("amount_requested");
			     float roi=rs.getFloat("roi");
			     int tenure=rs.getInt("tenure");
			     float monthlyInterestRate = roi / 100 / 12;


			     float emi =(float) ((amount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenure)) / (Math.pow(1 + monthlyInterestRate, tenure) - 1));
				sql="insert into activeloans values(?,?,?,?,SYSDATE,?,loanidSeq.nextval,?,?,?,?,?,?)";
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
				ps.setInt(10, 1);
				ps.setFloat(11, emi);
		        ps.executeUpdate();	
		        
		        System.out.println("inserted into activeloans");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	return true;	
	}

	@Override
	public boolean reject(String userName, String applyid, String rejectReason) {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String sql="update loanapplication set Application_status=0,reject_reason=? where application_id=? ";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, rejectReason);
			ps.setString(2, applyid);
			ps.executeUpdate();
			System.out.println("updated application");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
		return true;
	}

	@Override
	public Nominee getNomineeDetails(String applicationNum) {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		Nominee n=null;
		String sql="select * from nomineedetails where application_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, applicationNum);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				n=new Nominee();
				n.setName(rs.getString("nominee_name"));
				n.setPhoneNo(rs.getLong("phone_num"));
				n.setRelationship(rs.getString("relationship"));
				n.setAddress(rs.getString("address"));
				n.setApplication_id(applicationNum);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return n;	}

	@Override
	public String getCustomerId(String applyId) {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String custId=null;
		String sql="select customer_id from loanapplication where application_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, applyId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			custId=rs.getString("customer_id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custId;
	}

	@Override
	public Customer getCustomerDetails(String custId) {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String sql="select * from customerdetails where customer_id=?";
		Customer custData=null;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, custId);
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
	public List<DocumentRetrievalData> getDocumentData(String applicationId) {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String sql="select * from documents where applicationid=? ";
		List<DocumentRetrievalData> docList=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, applicationId);			
			ResultSet rs=ps.executeQuery();
			
		    while(rs.next()) {
		    	DocumentRetrievalData data=new DocumentRetrievalData();
		    	data.setDocName(rs.getString("file_name"));
		    	Blob blob=rs.getBlob("file_data");
		    	if(blob!=null) {
		    	data.setDoclData(blob.getBytes(1,(int)blob.length()));	
		    	}
		    	docList.add(data);
		    	
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return docList;
	}

}
