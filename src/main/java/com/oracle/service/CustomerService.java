package com.oracle.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
//@Component
public interface CustomerService {
	public String insertCustomerDetailsService(Customer cdata,String uName );//tested
	public boolean insertNomineeDetailsService(Nominee ndata,String custId);
	public boolean saveDocumentService(List<MultipartFile> files,String applicationId);
	public boolean addNewCustomerDetailsService(ClerkCustomer cdata);
	public String getCustomerIdService(String userName);//tested
	public String saveApplicationDataService(String custId ,Application data);
	public List<Application> getAppllicationsByIdService(String custId);//tested
	public boolean cancelApplicationService(String application_id);//tested
	public long closeLoanService(int loanId);//tested
	public Customer getCustomerDetailsService(String userName);//tested
	public List<Program> getProgramNamesService(String prgmType);
	List<ActiveLoans> getLoanDetailsService(String userName);//tested
	List<Transaction> getMyTransactionsService(long loanId);

	
}
