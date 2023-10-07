package com.oracle.service;
import java.util.UUID;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.dao.DBConnection;
import com.oracle.entity.Application;
import com.oracle.entity.ClerkCustomer;
import com.oracle.entity.CompleteCustomerDetails;
import com.oracle.entity.Customer;
import com.oracle.entity.DocumentData;
import com.oracle.entity.Nominee;
import com.oracle.entity.Program;
import com.oracle.entity.pdfDocument;
@Component
public class CustomerServiceImpl implements CustomerService {

	
	 public String insertCustomerDetails(Customer cdata,String uName ) {
	    	DBConnection dbcon=new DBConnection();
			Connection con=dbcon.connect();
			String sql="insert into customerdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			String custId = UUID.randomUUID().toString();		
			
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,uName);
				ps.setString(2, custId);
				ps.setString(3,cdata.getFirstName());
				ps.setString(4,cdata.getLastName());
				ps.setDate(5,cdata.getDob());
				ps.setString(6, cdata.getEmail());
				ps.setLong(7,cdata.getPhoneNo());
				ps.setString(8, cdata.getOccupation());
				ps.setString(9, cdata.getEmp_type());
				ps.setString(10, cdata.getGender());
				ps.setLong(11, cdata.getIncome());
				ps.setInt(12,cdata.getCreditScore());
				ps.setDate(13,cdata.getRegDate());
				ps.setString(14, cdata.getAccountStatus());
				ps.setString(15,cdata.getAddress());
				ps.setString(16,cdata.getCity());
				ps.setString(17, cdata.getState());
				ps.setString(18, cdata.getCountry());
				ps.setInt(19,cdata.getPincode());
	            ps.executeUpdate();
	            System.out.println("cust details added");         
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "failed";
			}
			return "success";
	    }

	

	
	public boolean insertNomineeDetails(Nominee ndata, String userId) {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		
		try {					
		     String sql="insert into nomineedetails values(?,nomineeseq.nextval,?,?,?,?,?) ";
			PreparedStatement ps=con.prepareStatement(sql);
		     ps=con.prepareStatement(sql);
		     ps.setString(1, userId);
		     ps.setString(2, ndata.getName());
		     ps.setLong(3, ndata.getPhoneNo());
		     ps.setString(4, ndata.getRelationship());
		     ps.setString(5, ndata.getAddress());
		     ps.setString(6, ndata.getApplication_id());
		     ps.executeUpdate();
			System.out.println("nominee details inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean saveDocument(String custId,DocumentData docData) {
		// TODO Auto-generated method stub
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String loan_type=docData.getLoanType();
		List<MultipartFile> files=docData.getFile();
		String	sql="insert into  documents values(?,?,?,?)";	
		for(MultipartFile file:files) {
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			byte[] filedata=file.getBytes();
			ps.setString(1, custId);
			ps.setString(2, loan_type);
			ps.setBytes(3, filedata);
			ps.setString(4, file.getOriginalFilename());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
public String getCustomerId(String userName) {
	
	DBConnection dbcon=new DBConnection();
	Connection con=dbcon.connect();
	String custId=null;
	String sql="select customer_id from customerdetails  where username=?";			
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1,userName );
		ResultSet rs= ps.executeQuery();
		rs.next();
		 custId=rs.getString(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return custId;
}




@Override
public String saveApplicationData(String custId, Application data) {
	DBConnection dbcon=new DBConnection();
	Connection con=dbcon.connect();
	String applicationNumber = null;
	String sql="select * from activeloans where loan_type=? and customerid=? and loan_status!=0";
	
	
	 
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,data.getLoanType() );
		ps.setString(2, custId);
		ResultSet rs=ps.executeQuery();
		if(rs.next())return null;
		applicationNumber = UUID.randomUUID().toString();
		sql="insert into loanapplication values(?,?,?,?,?,?,?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setString(1, custId);
		ps.setString(2, applicationNumber);
		System.out.println(data.getApplicationId()+"    applyid");
		ps.setString(3,data.getLoanType());
		System.out.println(data.getLoanType()+"    type");
		ps.setString(4, data.getProgramName());
		ps.setInt(5, data.getApplicationStatus());
		ps.setLong(6, data.getAmountRequested());
		ps.setDate(7,data.getApplicationDate());
		ps.setString(8, data.getRejectReason());
		ps.setFloat(9, data.getRoi());
		ps.setInt(10, data.getTenure());
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return applicationNumber;
}




@Override
public List<Application> getAppllicationsById(String custId) {
	// TODO Auto-generated method stub
	DBConnection dbcon=new DBConnection();
	Connection con=dbcon.connect();
	String sql="select * from loanapplication where customer_id=? ";
	List<Application> applicationData=new ArrayList<>();
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, custId);
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




public boolean cancelApplication(String application_id) {
	// TODO Auto-generated method stub
	DBConnection dbcon=new DBConnection();
	Connection con=dbcon.connect();
	String sql="update loanapplication set Application_status=3 where application_id=? ";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, application_id);
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return true;
}




@Override
public long closeLoan(int loanId) {
	// TODO Auto-generated method stub
	long paidAmount=0;
	long amountSanctioned=-1;
	DBConnection dbcon=new DBConnection();
	Connection con=dbcon.connect();
	String sql="select amount_paid,amount_sanctioned from activeloans where  loan_id= ?";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, loanId);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			 paidAmount=rs.getLong("amount_paid");
			 amountSanctioned=rs.getLong("amount_sanctioned");
			if(paidAmount==amountSanctioned) {
				sql="update activeloans set loan_status=0 where loan_id= ?";
			    ps=con.prepareStatement(sql);
				ps.setInt(1, loanId);
				ps.executeUpdate();
				return 0;}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 return amountSanctioned-paidAmount;
}




@Override
public Customer getCustomerDetails(String userName) {
	// TODO Auto-generated method stub
	DBConnection dbcon=new DBConnection();
	Connection con=dbcon.connect();
	String sql="select * from customerdetails where username=?";
	Customer custData=null;
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, userName);
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
public List<Program> getProgramNames(String prgmType) {
	// TODO Auto-generated method stub
	DBConnection dbcon=new DBConnection();
	Connection con=dbcon.connect();
	List<Program> prgmDetails=prgmDetails=new ArrayList<>();
	
	String sql="select * from programdetails where loan_type=?";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, prgmType);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Program p=new Program();
			p.setLoanType(rs.getString("loan_type"));
			p.setProgramName(rs.getString("program_name"));
			p.setMin_amt(rs.getLong("min_amount"));
			p.setMax_amt(rs.getLong("max_amount"));
			p.setMin_tenure(rs.getLong("min_tenure"));
			p.setMax_tenure(rs.getLong("max_tenure"));
			p.setRoi(rs.getFloat("roi"));
			p.setProgramDescription(rs.getString("program_desc"));
			prgmDetails.add(p);
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return prgmDetails;
}




	
}
