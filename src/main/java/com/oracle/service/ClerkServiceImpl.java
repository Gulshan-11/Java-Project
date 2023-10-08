package com.oracle.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.dao.ClerkDao;
import com.oracle.dao.DBConnection;
import com.oracle.entity.ActiveLoans;
import com.oracle.entity.Application;
import com.oracle.entity.Customer;
@Component
public class ClerkServiceImpl implements ClerkService {

    @Autowired
    private ClerkDao clerkdao;
	public List<Application> getAllApplicationsService() {
        return clerkdao.getAllApplications();
		
	}

	@Override
	public Customer getgetCustomerDetailsByIdService(String CustomerId) {
	
		return clerkdao.getgetCustomerDetailsById(CustomerId);
		
	}

	@Override
	public ActiveLoans getLoanDetailsByIdService(int loanId) {
		// TODO Auto-generated method stub
		
		return  clerkdao.getLoanDetailsById(loanId);
	}
	public List<ActiveLoans> getLoanDetailsService() {
		return clerkdao.getLoanDetails();
	}

}
