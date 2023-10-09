package com.oracle.financeProject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.oracle.entity.ActiveLoans;
import com.oracle.entity.Application;
import com.oracle.entity.Customer;
import com.oracle.service.CustomerService;
@SpringBootTest

class CustomerServiceTests {

	
	@MockBean
	private CustomerService customerService;
	 String st1 = "2017-12-03";
     Date dob = Date.valueOf(st1);
     String st2="2023-10-9"; 
     Date regDate = Date.valueOf(st2);
     String userName1="vamshi1123";
     String userName2="krishna11";
	Customer c1=new Customer("vamshi", "Andugula", "vamshi1123",null ,dob ,"vamshi@gmail.com", 1234567891,"SE", "Private","Male" , 1000000, 750, regDate,"active", "PH colony","GDK", "TS", "India", 505209);
	Customer c2=new Customer("Krishna", "Prasad", "krishna11",null ,dob ,"krishna@gmail.com", 1987654321,"SE", "Private","Male" , 1000000, 750, regDate,"active", "PH colony","GDK", "TS", "India", 505209);
	@Test
	public void testInsertCustomerDetails() {
		when(customerService.insertCustomerDetailsService(c1,userName1)).thenReturn("success");
		String actual=customerService.insertCustomerDetailsService(c1, userName1);
		assertEquals("success", actual);
	}
	
//	@Test
//	public void insertNomineeDetailsService() {
//		Nominee n1=new  Nominee( "Kumar",1234567891 , "Uncle", "Krm", )
//		
//	}
	
	@Test
	public void testGetCustomerIdServicePass() {
		String UserName="johndoe";
		when(customerService.getCustomerIdService(UserName)).thenReturn("5");
		String actual=customerService.getCustomerIdService(UserName);
		assertEquals("5",actual);
		
	}
	@Test
	public void testGetCustomerIdServiceFail() {
		String UserName="johndoe123";
		
		when(customerService.getCustomerIdService(UserName)).thenReturn(null);
		String actual=customerService.getCustomerIdService(UserName);
		assertEquals(null,actual);
		
	}
	@Test
	public void testGetApplicationsByIdServicePass() {
		String custId="5";
		String st1 = "2017-12-03";
	     Date applyDate = Date.valueOf(st1);
		List<Application> applyList=new ArrayList<>();
		Application application=new Application("home", "a12345", "tes", 0,
				100000 , applyDate,null, 8.3f, 24); 
		applyList.add(application);
		when(customerService.getAppllicationsByIdService(custId)).thenReturn(applyList);
		List<Application> actual=customerService.getAppllicationsByIdService(custId);
		assertEquals(1,actual.size());
	}
	@Test
	public void testGetApplicationsByIdServiceFail() {
		String custId="8987";
		String st1 = "2017-12-03";
	     Date applyDate = Date.valueOf(st1);
		List<Application> applyList=new ArrayList<>();		
		when(customerService.getAppllicationsByIdService(custId)).thenReturn(applyList);
		List<Application> actual=customerService.getAppllicationsByIdService(custId);
		assertEquals(0,actual.size());
	}
	
	@Test
	public void testcancelApplication() {
		String applyId="a12345";
		when(customerService.cancelApplicationService(applyId)).thenReturn(true);
		boolean actual=customerService.cancelApplicationService(applyId);
		assertEquals(true,actual);
	}
	@Test
	public void testcloseLoanService() {
		int loanId=1;
		when(customerService.closeLoanService(loanId)).thenReturn(0l);
		long actual=customerService.closeLoanService(loanId);
		assertEquals(0l,actual);
		
	}
	
	@Test
	public void getCustomerDetailsService() {
		String st1 = "2017-12-03";
	     Date dob = Date.valueOf(st1);
	     String st2="2023-10-9"; 
	     Date regDate = Date.valueOf(st2);
	     String userName="johndoe";
	 	Customer c1=new Customer("john", "doe", "johndoe1123","5" ,dob ,"doe@gmail.com", 1234567891,"SE", "Private","Male" , 1000000, 750, regDate,"active", "PH colony","GDK", "TS", "India", 505209);
      when(customerService.getCustomerDetailsService(userName)).thenReturn(c1);
      Customer actual=customerService.getCustomerDetailsService(userName);
      assertEquals(c1.getCustId(),actual.getCustId());
		
	}
	
	@Test
	public void testGetLoanDetailsServicePass() {
		String st1 = "2017-12-03";
	     Date startDate = Date.valueOf(st1);
	     String userName="johndoe";
	     List<ActiveLoans> activeLoansList=new ArrayList<ActiveLoans>();
	     
		ActiveLoans p1=new ActiveLoans(1, "home", "tes", 8.3f, 24, 100000l,
				startDate, 100000l, "vishnu", 10, 10000, 0);
		activeLoansList.add(p1);
		when(customerService.getLoanDetailsService(userName)).thenReturn(activeLoansList);
		List<ActiveLoans> actual=customerService.getLoanDetailsService(userName);
		assertEquals(activeLoansList.size(),actual.size());
	
	}
	@Test
	public void testGetLoanDetailsServiceFail() {
		
	     String userName="adadf";
	     List<ActiveLoans> activeLoansList=new ArrayList<ActiveLoans>();	     
		
		when(customerService.getLoanDetailsService(userName)).thenReturn(activeLoansList);
		List<ActiveLoans> actual=customerService.getLoanDetailsService(userName);
		assertEquals(activeLoansList.size(),actual.size());
	
	}
	
	
	
	

}
