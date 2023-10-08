package com.oracle.service;

import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import com.oracle.entity.ActiveLoans;
import com.oracle.entity.Application;
import com.oracle.entity.ClerkCustomer;
import com.oracle.entity.CompleteCustomerDetails;
import com.oracle.entity.Customer;
import com.oracle.entity.DocumentData;
import com.oracle.entity.Nominee;
import com.oracle.entity.Program;
import com.oracle.entity.pdfDocument;

public interface CustomerService {
	public String insertCustomerDetailsService(Customer cdata,String uName );
	public boolean insertNomineeDetailsService(Nominee ndata,String custId);
	public boolean saveDocumentService(List<MultipartFile> files,String applicationId);
	public boolean addNewCustomerDetailsService(ClerkCustomer cdata);
	public String getCustomerIdService(String userName);
	public String saveApplicationDataService(String custId ,Application data);
	public List<Application> getAppllicationsByIdService(String custId);
	public boolean cancelApplicationService(String applicatuion_id);
	public long closeLoanService(int loanId);
	public Customer getCustomerDetailsService(String userName);
	public List<Program> getProgramNamesService(String prgmType);
	List<ActiveLoans> getLoanDetailsService(String userName);

	
}
