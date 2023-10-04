package com.oracle.dao;

import java.util.List;
import com.oracle.entity.*;
public interface CustomerDao {
List<Customer> getCustomerDetails();
List<ActiveLoans> getLoanDetails(String userName);


	
}
