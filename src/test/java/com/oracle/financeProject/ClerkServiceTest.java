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
import com.oracle.entity.Customer;
import com.oracle.service.ClerkService;
@SpringBootTest

class ClerkServiceTest {

	@MockBean
	private ClerkService clerkService;
	
	@Test
	public void testgetLoanDetailsByIdServicePass() {
		String st1 = "2017-12-03";
	     Date startDate = Date.valueOf(st1);   
	    
	     
		ActiveLoans expected=new ActiveLoans(1, "home", "tes", 8.3f, 24, 100000l,
				startDate, 100000l, "vishnu", 10, 10000, 0);
	
		when(clerkService.getLoanDetailsByIdService(1)).thenReturn(expected);
	    ActiveLoans actual=clerkService.getLoanDetailsByIdService(1);
		assertEquals(expected.getLoanId(),actual.getLoanId());
	}
	@Test
	public void testgetLoanDetailsByIdServiceFail() {
	     
		when(clerkService.getLoanDetailsByIdService(909)).thenReturn(null);
	    ActiveLoans actual=clerkService.getLoanDetailsByIdService(1);
		assertEquals(null,actual);
	}
	@Test
	public void getLoanDetailsService() {
		List<ActiveLoans> expected=new ArrayList<>();
		String st1 = "2017-12-03";
	     Date startDate = Date.valueOf(st1);      
	     
		ActiveLoans al1=new ActiveLoans(1, "home", "tes", 8.3f, 24, 100000l,
				startDate, 100000l, "vishnu", 10, 10000, 0);
		expected.add(al1);
		when(clerkService.getLoanDetailsService()).thenReturn(expected);
		List<ActiveLoans> actual=clerkService.getLoanDetailsService();
		assertEquals(expected.size(), actual.size());
		
	}
	
	@Test
	public void getgetCustomerDetailsByIdServicePass() {
		String st1 = "2017-12-03";
	     Date dob = Date.valueOf(st1);
	     String st2="2023-10-9"; 
	     Date regDate = Date.valueOf(st2);
	     String custId="5";
	 	Customer c1=new Customer("john", "doe", "johndoe1123","5" ,dob ,"doe@gmail.com", 1234567891,"SE", "Private","Male" , 1000000, 750, regDate,"active", "PH colony","GDK", "TS", "India", 505209);
     when(clerkService.getgetCustomerDetailsByIdService(custId)).thenReturn(c1);
     Customer actual=clerkService.getgetCustomerDetailsByIdService(custId);
     assertEquals(c1.getCustId(),actual.getCustId());
		
	}
	@Test
	public void getgetCustomerDetailsByIdServicePassFail() {
		String st1 = "2017-12-03";
	     Date dob = Date.valueOf(st1);
	     String st2="2023-10-9"; 
	     Date regDate = Date.valueOf(st2);
	     String custId="8812731";
     when(clerkService.getgetCustomerDetailsByIdService(custId)).thenReturn(null);
     Customer actual=clerkService.getgetCustomerDetailsByIdService(custId);
     assertEquals(null,actual);
		
	}
}
