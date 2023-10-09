package com.oracle.service;
import java.util.UUID;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
import com.oracle.entity.Transaction;
import com.oracle.entity.pdfDocument;
@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	 public String insertCustomerDetailsService(Customer cdata,String uName ) {
	    return customerDao.insertCustomerDetails(cdata, uName);
	    }

	
	
	
	public boolean insertNomineeDetailsService(Nominee ndata, String userId) {
		// TODO Auto-generated method stub
		return customerDao.insertNomineeDetails(ndata, userId);
		
	}

	@Override
	public boolean saveDocumentService(List<MultipartFile> files,String applicationId) {
		// TODO Auto-generated method stub
		return customerDao.saveDocument(files, applicationId);
	}
   public boolean addNewCustomerDetailsService(ClerkCustomer cdata) {
	   return customerDao.addNewCustomerDetails(cdata);
   }




@Override
public String getCustomerIdService(String userName) {
	
	return customerDao.getCustomerId(userName);
}




@Override
public String saveApplicationDataService(String custId, Application data) {
	return customerDao.saveApplicationData(custId, data);
}




@Override
public List<Application> getAppllicationsByIdService(String custId) {
	// TODO Auto-generated method stub
	return customerDao.getAppllicationsById(custId);
}




public boolean cancelApplicationService(String application_id) {
	// TODO Auto-generated method stub
	return customerDao.cancelApplication(application_id);

}




@Override
public long closeLoanService(int loanId) {
	// TODO Auto-generated method stub
	return customerDao.closeLoan(loanId);
}




@Override
public Customer getCustomerDetailsService(String userName) {
	// TODO Auto-generated method stub
	return customerDao.getCustomerDetails(userName);
}




@Override
public List<Program> getProgramNamesService(String prgmType) {
	// TODO Auto-generated method stub
     return customerDao.getProgramNames(prgmType);
}




@Override
public List<ActiveLoans> getLoanDetailsService(String userName) {
	// TODO Auto-generated method stub
	return customerDao.getLoanDetails(userName);
}




@Override
public List<Transaction> getMyTransactionsService(long loanId) {
	// TODO Auto-generated method stub
	return customerDao.getMyTransactions(loanId);
}

	
}
