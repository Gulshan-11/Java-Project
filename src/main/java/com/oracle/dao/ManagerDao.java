package com.oracle.dao;

import java.util.List;

import com.oracle.entity.Application;
import com.oracle.entity.Customer;
import com.oracle.entity.DocumentRetrievalData;
import com.oracle.entity.Nominee;

public interface ManagerDao {
	List<Application> getAllApplication();
    boolean approveLoan(String userName,String applyId);
    boolean reject(String userName,String appli_id,String rejectReason);
    Nominee getNomineeDetails(String applicationNum);
    String getCustomerId(String applyId);
    Customer getCustomerDetails(String custId);
    List<DocumentRetrievalData> getDocumentData(String applicationId);
}
