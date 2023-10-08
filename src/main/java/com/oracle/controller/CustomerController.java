package com.oracle.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.dao.ApplyDetails;
import com.oracle.dao.CustomerDao;
import com.oracle.dao.DBConnection;
import com.oracle.entity.ActiveLoans;
import com.oracle.entity.Application;
import com.oracle.entity.ClerkCustomer;
import com.oracle.entity.CompleteCustomerDetails;
import com.oracle.entity.Customer;
import com.oracle.entity.DocumentData;
import com.oracle.entity.Nominee;
import com.oracle.entity.Program;
import com.oracle.entity.pdfDocument;
import com.oracle.exceptions.ApplicationException;
import com.oracle.secure.config.JwtTokenUtil;
import com.oracle.service.CustomerService;
@RestController
@CrossOrigin
public class CustomerController {

	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/loandetails/{token}" ,  method=RequestMethod.GET)
	public List<ActiveLoans> getDetailsOfLoan(@PathVariable String token ){
		String userName=jwtTokenUtil.getUsernameFromToken(token);
		return customerService.getLoanDetailsService(userName);
	}
@RequestMapping(value="/MyDetails/{token}",method=RequestMethod.POST)
public Customer getDetailsOfCustomer(@PathVariable String token) {
	String userName=jwtTokenUtil.getUsernameFromToken(token);
	 return customerService.getCustomerDetailsService(userName);
}
	@RequestMapping(value="/SaveDetails/{token}" ,  method=RequestMethod.POST)
	//@RequestBody MultipartFile[] file
	public String apply(@PathVariable String token,@RequestBody Customer details) {
		String userName=jwtTokenUtil.getUsernameFromToken(token);		
		return customerService.insertCustomerDetailsService(details,userName);
	}
	
	
	@RequestMapping(value="/searchByLoanId/{token}",method=RequestMethod.POST)
	public ActiveLoans searchbyLoanId(@PathVariable String token,@RequestBody int loanId ) {
		String userName=jwtTokenUtil.getUsernameFromToken(token);
		String cust_id=customerService.getCustomerIdService(userName);
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String	sql="select * from ActiveLoans where loan_id=? ";
		ActiveLoans loandata=new ActiveLoans();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, loanId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				loandata.setAmountPaid(rs.getLong("Amount_paid"));
				loandata.setAmountSanctioned(rs.getLong("Amount_sanctioned"));
				loandata.setApproverName(rs.getString("approver_name"));
				loandata.setDate(rs.getDate("start_date"));
				loandata.setEmisPaid(rs.getInt("emis_paid"));
				loandata.setLoanId(rs.getInt("loan_id"));
				loandata.setProgrameName(rs.getString("programe_name"));
				loandata.setRoi(rs.getInt("roi"));
				loandata.setTenure(rs.getInt("tenure"));
				loandata.setType(rs.getString("loan_type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loandata;
		
	}
	@RequestMapping(value="/searchByLoanType/{token}",method=RequestMethod.POST)
	public ActiveLoans searchbyLoanType(@PathVariable String token,@RequestBody String type ) {
		String userName=jwtTokenUtil.getUsernameFromToken(token);
		String cust_id=customerService.getCustomerIdService(userName);
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String	sql="select * from ActiveLoans where loan_type=? ";
		ActiveLoans loandata=new ActiveLoans();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, type);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				loandata.setAmountPaid(rs.getLong("Amount_paid"));
				loandata.setAmountSanctioned(rs.getLong("Amount_sanctioned"));
				loandata.setApproverName(rs.getString("approver_name"));
				loandata.setDate(rs.getDate("start_date"));
				loandata.setEmisPaid(rs.getInt("emis_paid"));
				loandata.setLoanId(rs.getInt("loan_id"));
				loandata.setProgrameName(rs.getString("programe_name"));
				loandata.setRoi(rs.getInt("roi"));
				loandata.setTenure(rs.getInt("tenure"));
				loandata.setType(rs.getString("loan_type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loandata;
		
	}
	
	@RequestMapping(value="/searchByLoanDate/{token}",method=RequestMethod.POST)//date
	public ActiveLoans searchbyLoanDate(@PathVariable String token,@RequestBody Date date ) {
		String userName=jwtTokenUtil.getUsernameFromToken(token);
		String cust_id=customerService.getCustomerIdService(userName);
		DBConnection dbcon=new DBConnection();
		Connection con=dbcon.connect();
		String	sql="select * from ActiveLoans where start_date=? ";
		ActiveLoans loandata=new ActiveLoans();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setDate(1, date);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				loandata.setAmountPaid(rs.getLong("Amount_paid"));
				loandata.setAmountSanctioned(rs.getLong("Amount_sanctioned"));
				loandata.setApproverName(rs.getString("approver_name"));
				loandata.setDate(rs.getDate("start_date"));
				loandata.setEmisPaid(rs.getInt("emis_paid"));
				loandata.setLoanId(rs.getInt("loan_id"));
				loandata.setProgrameName(rs.getString("programe_name"));
				loandata.setRoi(rs.getInt("roi"));
				loandata.setTenure(rs.getInt("tenure"));
				loandata.setType(rs.getString("loan_type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loandata;
		
	}
	@RequestMapping(value="/ApplyLoan/{token}" ,  method=RequestMethod.POST)//success tested
   public String apply(@PathVariable String token,@RequestBody Application data) {
		String userName=jwtTokenUtil.getUsernameFromToken(token);
		String cust_id=customerService.getCustomerIdService(userName);
		if(cust_id==null) throw new ApplicationException("Customer Not Found");
		String res=customerService.saveApplicationDataService(cust_id,data);
		if(res==null)
				return "exists";
		return res;
	}
	@RequestMapping(value="/GetApplications/{token}" ,  method=RequestMethod.GET)//success tested
     public  List<Application> myapplications(@PathVariable String token) {
		String userName=jwtTokenUtil.getUsernameFromToken(token);
		String cust_id=customerService.getCustomerIdService(userName);
		if(cust_id==null) throw new ApplicationException("Customer Not Found");
		return customerService.getAppllicationsByIdService(cust_id);

		
	}
	@RequestMapping(value="/ApplicationClose/{applyid}" ,  method=RequestMethod.POST)//success tested
	public boolean CloseApplication(@PathVariable String applyid) {
		
		return customerService.cancelApplicationService(applyid);
	}
	
	@RequestMapping(value="/CloseLoan/{loanId}" ,  method=RequestMethod.POST)
	public long closeCustomerLoan(@PathVariable  int loanId) {
		return customerService.closeLoanService(loanId);
		
	}
	
	//loan programs by type
	@RequestMapping(value="/ProgramNames/{prgmName}",method=RequestMethod.GET)
	public List<Program> getPrograms(@PathVariable String prgmName) {
		return customerService.getProgramNamesService(prgmName);
	}
	@RequestMapping(value="/addNominee/{token}",method=RequestMethod.POST)
	public String addNomineeDetails(@PathVariable String token,@RequestBody Nominee ndata) {
		String userName=jwtTokenUtil.getUsernameFromToken(token);
		String userId=customerService.getCustomerIdService(userName);
		if(customerService.insertNomineeDetailsService(ndata, userId))		
		return "success";
		return "fail";
	}
	
	@RequestMapping(value="/AddDocument",method=RequestMethod.POST, consumes = "multipart/form-data")
	public boolean addDocument( @RequestParam("files") List<MultipartFile> files,@RequestParam("applicationId") String applicationId) {
		return customerService.saveDocumentService(files, applicationId);
	
		
	}
	

	
	
}
