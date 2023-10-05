package com.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.entity.ClerkCustomer;
import com.oracle.service.CustomerService;

public class ClerckController {
//apply
//close appli
	@Autowired
	private CustomerService customerService;
	@RequestMapping(value="/AddNewCustomer" ,  method=RequestMethod.POST)
	public String addNewCustomer(@RequestBody ClerkCustomer ccData ) {
		customerService.addNewCustomerDetails(ccData);
		return "success";
	}
   
	
	
}
