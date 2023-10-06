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
import com.oracle.entity.Nominee;
import com.oracle.entity.Program;
import com.oracle.entity.pdfDocument;
import com.oracle.service.CustomerService;
@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerDao custdao;
	
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/loandetails" ,  method=RequestMethod.POST)
	public List<ActiveLoans> getDetailsOfLoan(@RequestBody String userName ){
		return custdao.getLoanDetails(userName);
	}
@RequestMapping(value="/MyDetails/{userName}",method=RequestMethod.POST)
public Customer getDetailsOfCustomer(@PathVariable String userName) {
	 return customerService.getCustomerDetails(userName);
}
	@RequestMapping(value="/SaveDetails/{userName}" ,  method=RequestMethod.POST)
	//@RequestBody MultipartFile[] file
	public String apply(@PathVariable String userName,@RequestBody Customer details) {
		
		return customerService.insertCustomerDetails(details,userName);
		//System.out.println("custobj:"+details.getCustomerData());
//		customerService.insertNomineeDetails(details,userName);
		//System.out.println("nomiobj:"+details.getNomineeData());
		
//		for (MultipartFile eachfile: file) {
//			pdfDocument doc=new pdfDocument();
//			try {
//				doc.setPdfData(eachfile.getBytes());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			doc.setCustomerId(details.getCustomerData().getCustId());
//			
//			customerService.saveDocument(doc);
//			System.out.println("success");
//		}
	}
	
	
	@RequestMapping(value="/searchByLoanId/{userName}",method=RequestMethod.POST)
	public ActiveLoans searchbyLoanId(@PathVariable String userName,@RequestBody int loanId ) {
		String cust_id=customerService.getCustomerId(userName);
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
	@RequestMapping(value="/searchByLoanType/{userName}",method=RequestMethod.POST)
	public ActiveLoans searchbyLoanType(@PathVariable String userName,@RequestBody String type ) {
		String cust_id=customerService.getCustomerId(userName);
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
	
	@RequestMapping(value="/searchByLoanDate/{userName}",method=RequestMethod.POST)//date
	public ActiveLoans searchbyLoanDate(@PathVariable String userName,@RequestBody Date date ) {
		String cust_id=customerService.getCustomerId(userName);
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
	@RequestMapping(value="/ApplyLoan/{userName}" ,  method=RequestMethod.POST)//success tested
   public String apply(@PathVariable String userName,@RequestBody Application data) {
		String cust_id=customerService.getCustomerId(userName);
		String res=customerService.saveApplicationData(cust_id,data);
		if(res==null)
				return "exists";
		return res;
	}
	@RequestMapping(value="/GetApplications/{userName}" ,  method=RequestMethod.GET)//success tested
     public  List<Application> myapplications(@PathVariable String userName) {
		String cust_id=customerService.getCustomerId(userName);
		return customerService.getAppllicationsById(cust_id);

		
	}
	@RequestMapping(value="/ApplicationClose/{applyid}" ,  method=RequestMethod.POST)//success tested
	public void CloseApplication(@PathVariable String applyid) {
		
		customerService.cancelApplication(applyid);
	}
	
	@RequestMapping(value="/CloseLoan/{loanId}" ,  method=RequestMethod.POST)
	public long closeCustomerLoan(@PathVariable  int loanId) {
		return customerService.closeLoan(loanId);
		
	}
	
	//loan programs by type
	@RequestMapping(value="/ProgramNames/{prgmName}",method=RequestMethod.GET)
	public List<Program> getPrograms(@PathVariable String prgmName) {
		return customerService.getProgramNames(prgmName);
	}
	@RequestMapping(value="/addNominee/{username}",method=RequestMethod.POST)
	public String addNomineeDetails(@PathVariable String username,@RequestBody Nominee ndata) {
		String userid=customerService.getCustomerId(username);
		if(customerService.insertNomineeDetails(ndata, userid))		
		return "success";
		return "fail";
	}
	

	
	
}
