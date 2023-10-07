package com.oracle.service;

import java.util.List;

import com.oracle.entity.Application;
import com.oracle.entity.Customer;
import com.oracle.entity.DocumentData;
import com.oracle.entity.DocumentRetrievalData;
import com.oracle.entity.Nominee;

public interface ManagerService {
         List<Application> getAllApplication();
         boolean approveLoan(String userName,String appli_id);
         boolean reject(String userName,String appli_id,String rejectReason);
         Nominee getNomineeDetails(String applicationNum);
         String getCustomerId(String applyId);
         Customer getCustomerDetails(String custId);
         List<DocumentRetrievalData> getDocumentData(String userName,String LoanType);
}
