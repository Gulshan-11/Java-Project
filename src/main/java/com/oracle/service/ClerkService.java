package com.oracle.service;

import java.util.List;

import com.oracle.entity.Application;
import com.oracle.entity.Customer;

public interface ClerkService {
	public List<Application> getAllApplications();
	public Customer getgetCustomerDetailsById(String CustomerId);
	
}
