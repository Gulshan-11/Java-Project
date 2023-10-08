package com.oracle.dao;

import java.util.List;

import com.oracle.entity.ActiveLoans;
import com.oracle.entity.Application;
import com.oracle.entity.Customer;

public interface ClerkDao {
	public List<Application> getAllApplications();
	public Customer getgetCustomerDetailsById(String CustomerId);
	public ActiveLoans getLoanDetailsById(int loanId);
	public List<ActiveLoans> getLoanDetails();
}
