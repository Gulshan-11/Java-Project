package com.oracle.service;

import java.util.List;

import com.oracle.entity.ActiveLoans;
import com.oracle.entity.Application;
import com.oracle.entity.Customer;

public interface ClerkService {
	public List<Application> getAllApplicationsService();
	public Customer getgetCustomerDetailsByIdService(String CustomerId);//tested
	public ActiveLoans getLoanDetailsByIdService(int loanId);//tested
	public List<ActiveLoans> getLoanDetailsService();//tested
	
}
