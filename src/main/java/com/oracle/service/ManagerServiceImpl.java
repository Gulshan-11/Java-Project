package com.oracle.service;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.dao.DBConnection;
import com.oracle.dao.ManagerDao;
import com.oracle.entity.Application;
import com.oracle.entity.Customer;
import com.oracle.entity.DocumentData;
import com.oracle.entity.DocumentRetrievalData;
import com.oracle.entity.Nominee;
@Component
public class ManagerServiceImpl implements ManagerService {

	@Autowired ManagerDao managerDao;
	
	public List<Application> getAllApplicationService() {
		// TODO Auto-generated method stub
		return managerDao.getAllApplication();
	}
	// 0 ->reject
	// 1->accept
	// 2->pending
public boolean approveLoanService(String username,String applyid) {
	return managerDao.approveLoan(username, applyid);
}
@Override
public boolean rejectService(String userName, String applyid,String rejectReason)  {
	// TODO Auto-generated method stub
	return managerDao.reject(userName, applyid, rejectReason);
}
@Override
public Nominee getNomineeDetailsService(String applicationNum) {
	// TODO Auto-generated method stub
	return managerDao.getNomineeDetails(applicationNum);
}
@Override
public String getCustomerIdService(String applyId) {
	// TODO Auto-generated method stub
	return managerDao.getCustomerId(applyId);
}
@Override
public Customer getCustomerDetailsService(String custId) {
	// TODO Auto-generated method stub
	return managerDao.getCustomerDetails(custId);
}
@Override
public List<DocumentRetrievalData> getDocumentDataService(String applicationId) {
	// TODO Auto-generated method stub
	return managerDao.getDocumentData(applicationId);
}

	

}
