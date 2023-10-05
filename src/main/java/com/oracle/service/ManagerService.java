package com.oracle.service;

import java.util.List;

import com.oracle.entity.Application;

public interface ManagerService {
         List<Application> getAllApplication();
         boolean approveLoan(String userName,String appli_id);
         boolean reject(String userName,String appli_id);
         
}
