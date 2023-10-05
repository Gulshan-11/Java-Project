package com.oracle.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.oracle.entity.Application;
import com.oracle.entity.ClerkCustomer;
import com.oracle.entity.CompleteCustomerDetails;
import com.oracle.entity.Customer;
import com.oracle.entity.Nominee;
import com.oracle.entity.Program;
import com.oracle.entity.pdfDocument;

public interface CustomerService {
	public String insertCustomerDetails(Customer cdata,String uName );
	public boolean insertNomineeDetails(CompleteCustomerDetails ndata,String uName);
	public boolean saveDocument(pdfDocument docData);
	public boolean addNewCustomerDetails(ClerkCustomer cdata);
	public String getCustomerId(String userName);
	public boolean saveApplicationData(String custId ,Application data);
	public List<Application> getAppllicationsById(String custId);
	public boolean cancelApplication(String applicatuion_id);
	public long closeLoan(int loanId);
	public Customer getCustomerDetails(String userName);
	public List<Program> getProgramNames(String prgmType);
}
