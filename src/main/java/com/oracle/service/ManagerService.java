package com.oracle.service;

import java.util.List;

import com.oracle.entity.Application;
import com.oracle.entity.Customer;
import com.oracle.entity.DocumentData;
import com.oracle.entity.DocumentRetrievalData;
import com.oracle.entity.Nominee;

public interface ManagerService {
         List<Application> getAllApplicationService();
         boolean approveLoanService(String userName,String appli_id);
         boolean rejectService(String userName,String appli_id,String rejectReason);
         Nominee getNomineeDetailsService(String applicationNum);
         String getCustomerIdService(String applyId);//tested
         Customer getCustomerDetailsService(String custId);//tested
         List<DocumentRetrievalData> getDocumentDataService(String applicationId);
}
