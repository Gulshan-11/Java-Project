package com.oracle.service;

import org.springframework.web.multipart.MultipartFile;

import com.oracle.entity.ClerkCustomer;
import com.oracle.entity.CompleteCustomerDetails;
import com.oracle.entity.Customer;
import com.oracle.entity.Nominee;
import com.oracle.entity.pdfDocument;

public interface CustomerService {
	public boolean insertCustomerDetails(CompleteCustomerDetails cdata,String uName );
	public boolean insertNomineeDetails(CompleteCustomerDetails ndata,String uName);
	public boolean saveDocument(pdfDocument docData);
	public boolean addNewCustomerDetails(ClerkCustomer cdata);
	public int getCustomerId(String userName);
	
}
