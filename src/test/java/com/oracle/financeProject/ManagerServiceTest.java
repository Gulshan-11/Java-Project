package com.oracle.financeProject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.oracle.entity.Customer;
import com.oracle.service.ManagerService;
@SpringBootTest
class ManagerServiceTest {

	@MockBean
	private ManagerService managerService;
	
	
	@Test
	public void testGetCustomerDetailsByIdServicePass() {
		String st1 = "2017-12-03";
	     Date dob = Date.valueOf(st1);
	     String st2="2023-10-9"; 
	     Date regDate = Date.valueOf(st2);
	     String custId="5";
	 	Customer c1=new Customer("john", "doe", "johndoe1123","5" ,dob ,"doe@gmail.com", 1234567891,"SE", "Private","Male" , 1000000, 750, regDate,"active", "PH colony","GDK", "TS", "India", 505209);
     when(managerService.getCustomerDetailsService(custId)).thenReturn(c1);
     Customer actual=managerService.getCustomerDetailsService(custId);
     assertEquals(c1.getCustId(),actual.getCustId());
		
	}
	@Test
	public void testGetCustomerDetailsByIdServicePassFail() {
		
	     String custId="8812731";
     when(managerService.getCustomerDetailsService(custId)).thenReturn(null);
     Customer actual=managerService.getCustomerDetailsService(custId);
     assertEquals(null,actual);
		
	}
	
	@Test
	public void testgetCustomerIdServicePass() {
		String application_id="a12345";
		String expected="5";
		when(managerService.getCustomerIdService(application_id)).thenReturn(expected);
		String actual=managerService.getCustomerIdService(application_id);
		assertEquals(expected,actual);
		
	}
	@Test
	public void testgetCustomerIdServicePassFail() {
		String application_id="a12345adasda";
		String expected=null;
		when(managerService.getCustomerIdService(application_id)).thenReturn(expected);
		String actual=managerService.getCustomerIdService(application_id);
		assertEquals(expected,actual);
		
	}

}
