package com.oracle.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.dao.DBConnection;
import com.oracle.entity.ClerkCustomer;
import com.oracle.entity.CompleteCustomerDetails;
import com.oracle.entity.Customer;
import com.oracle.entity.Nominee;
import com.oracle.entity.pdfDocument;
@Component
public class CustomerServiceImpl implements CustomerService {

	
	 public boolean insertCustomerDetails(CompleteCustomerDetails cdata,String uName ) {
	    	DBConnection dbcon=new DBConnection();
			Connection con=dbcon.connect();
			String sql="insert into customerdetails values(?,custseq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,uName);
				ps.setString(2,cdata.getFirstName());
				ps.setString(3,cdata.getLastName());
				ps.setDate(4, cdata.getDob());
				ps.setString(5, cdata.getEmail());
				ps.setLong(6,cdata.getPhoneNo());
				ps.setString(7, cdata.getOccupation());
				ps.setString(8, cdata.getEmp_type());
				ps.setString(9, cdata.getGender());
				ps.setLong(10, cdata.getIncome());
				ps.setInt(11,cdata.getCreditScore());
				ps.setDate(12,cdata.getRegDate());
				ps.setString(13, cdata.getAccountStatus());
				ps.setString(14,cdata.getAddress());
				ps.setString(15,cdata.getCity());
				ps.setString(16, cdata.getState());
				ps.setString(17, cdata.getCountry());
				ps.setInt(18,cdata.getPincode());
	            ps.executeUpdate();
	            System.out.println("cust details added");
	           	sql="select customer_id from customerdetails  where username=?";			
				ps=con.prepareStatement(sql);
				ps.setString(1,uName );
				ResultSet rs= ps.executeQuery();
				rs.next();
				int custId=rs.getInt(1);
			     sql="insert into nomineedetails values(?,nomineeseq.nextval,?,?,?,?) ";
			     ps=con.prepareStatement(sql);
			     ps.setInt(1, custId);
			     ps.setString(2, cdata.getNomineeName());
			     ps.setLong(3, cdata.getNomineePhoneNo());
			     ps.setString(4, cdata.getRelationship());
			     ps.setString(5, cdata.getNomineeAddress());
			     ps.executeUpdate();
				System.out.println("nominee details inserted");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
	    }

	

	
	public boolean insertNomineeDetails(CompleteCustomerDetails ndata, String uName) {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		
		try {
			String	sql="select customer_id from customer  where username=?";			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,uName );
			ResultSet rs= ps.executeQuery();
			int custId=rs.getInt(1);
		     sql="insert into nominee values(?,nomineeseq.nextval,?,?,?,?) ";
		     ps=con.prepareStatement(sql);
		     ps.setInt(1, custId);
		     ps.setString(2, ndata.getNomineeName());
		     ps.setLong(3, ndata.getPhoneNo());
		     ps.setString(4, ndata.getRelationship());
		     ps.setString(5, ndata.getRelationship());
		     ps.executeUpdate();
			System.out.println("nominee details inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveDocument(pdfDocument docData) {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String	sql="insert into  documents values(?,?,?)";			
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, docData.getCustomer_id());
			ps.setString(2, docData.getLoan_type());
			ps.setBytes(3, docData.getPdfData());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
   public boolean addNewCustomerDetails(ClerkCustomer cdata) {
	   DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		
		try {
		String	sql="insert into userdetails values (?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);

	           ps=con.prepareStatement(sql);
	           ps.setString(1, cdata.getUsername());
	           ps.setString(2,cdata.getPassword() );
	           ps.setString(3,cdata.getRole());
	           ps.executeUpdate();

	           System.out.println("user details added");
	  		 sql="insert into customerdetails values(?,custseq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			 ps=con.prepareStatement(sql);
			ps.setString(1,cdata.getUserName());
			ps.setString(2,cdata.getFirstName());
			ps.setString(3,cdata.getLastName());
			ps.setDate(4, cdata.getDob());
			ps.setString(5, cdata.getEmail());
			ps.setLong(6,cdata.getPhoneNo());
			ps.setString(7, cdata.getOccupation());
			ps.setString(8, cdata.getEmp_type());
			ps.setString(9, cdata.getGender());
			ps.setLong(10, cdata.getIncome());
			ps.setInt(11,cdata.getCreditScore());
			ps.setDate(12,cdata.getRegDate());
			ps.setString(13, cdata.getAccountStatus());
			ps.setString(14,cdata.getAddress());
			ps.setString(15,cdata.getCity());
			ps.setString(16, cdata.getState());
			ps.setString(17, cdata.getCountry());
			ps.setInt(18,cdata.getPincode());
           ps.executeUpdate();
           System.out.println("cust details added");
           

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
   }




@Override
public int getCustomerId(String userName) {
	
	DBConnection dbcon=new DBConnection();
	Connection con=dbcon.connect();
	int custId=0;
	String sql="select customer_id from customerdetails  where username=?";			
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1,userName );
		ResultSet rs= ps.executeQuery();
		rs.next();
		 custId=rs.getInt(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return custId;
}




	
}
