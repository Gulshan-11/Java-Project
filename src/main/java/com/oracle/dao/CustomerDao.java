package com.oracle.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.oracle.entity.*;
public interface CustomerDao {
List<ActiveLoans> getLoanDetails(String userName);
public String insertCustomerDetails(Customer cdata,String uName );
public boolean insertNomineeDetails(Nominee ndata,String custId);
public boolean saveDocument(List<MultipartFile> files,String applicationId);
public boolean addNewCustomerDetails(ClerkCustomer cdata);
public String getCustomerId(String userName);
public String saveApplicationData(String custId ,Application data);
public List<Application> getAppllicationsById(String custId);
public boolean cancelApplication(String applicatuion_id);
public long closeLoan(int loanId);
public Customer getCustomerDetails(String userName);
public List<Program> getProgramNames(String prgmType);

	
}
