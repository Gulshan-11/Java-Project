package com.oracle.service;

import java.util.List;

import com.oracle.entity.Application;
import com.oracle.entity.Customer;
import com.oracle.entity.Nominee;

public interface ManagerService {
         List<Application> getAllApplication();
         boolean approveLoan(String userName,String appli_id);
         boolean reject(String userName,String appli_id);
         Nominee getNomineeDetails(String applicationNum);
         String getCustomerId(String applyId);
         Customer getCustomerDetails(String custId);
         
}
