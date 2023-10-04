package com.oracle.dao;

import com.oracle.entity.Customer;
import com.oracle.entity.Nominee;

public class ApplyDetails {
private Customer customerData;
private Nominee  nomineeData;

public ApplyDetails() {
	
}
public ApplyDetails(Customer customerData, Nominee nomineeData) {
	super();
	this.customerData = customerData;
	this.nomineeData = nomineeData;
}
public Customer getCustomerData() {
	return customerData;
}
public void setCustomerData(Customer customerData) {
	this.customerData = customerData;
}
public Nominee getNomineeData() {
	return nomineeData;
}
public void setNomineeData(Nominee nomineeData) {
	this.nomineeData = nomineeData;
}


}
