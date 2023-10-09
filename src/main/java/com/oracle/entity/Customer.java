package com.oracle.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Customer {
private String firstName;
private String lastName;
private String userName;
private String custId;
private Date dob;
private String email;
private long phoneNo;
private String occupation;
private String emp_type;
private String gender;
private long income;
private int creditScore;
private Date regDate;
private String accountStatus;
private String address;
private String city;
private String state;
private String country;
private int pincode;
public Customer() {}

public Customer(String firstName, String lastName, String userName, String custId, Date dob, String email, long phoneNo,
		String occupation, String emp_type, String gender, long income, int creditScore, Date regDate,
		String accountStatus, String address, String city, String state, String country, int pincode) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.custId = custId;
	this.dob = dob;
	this.email = email;
	this.phoneNo = phoneNo;
	this.occupation = occupation;
	this.emp_type = emp_type;
	this.gender = gender;
	this.income = income;
	this.creditScore = creditScore;
	this.regDate = regDate;
	this.accountStatus = accountStatus;
	this.address = address;
	this.city = city;
	this.state = state;
	this.country = country;
	this.pincode = pincode;
}

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getCustId() {
	return custId;
}
public void setCustId(String custId) {
	this.custId = custId;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(long phoneNo) {
	this.phoneNo = phoneNo;
}
public String getOccupation() {
	return occupation;
}
public void setOccupation(String occupation) {
	this.occupation = occupation;
}
public String getEmp_type() {
	return emp_type;
}
public void setEmp_type(String emp_type) {
	this.emp_type = emp_type;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public long getIncome() {
	return income;
}
public void setIncome(long income) {
	this.income = income;
}
public int getCreditScore() {
	return creditScore;
}
public void setCreditScore(int creditScore) {
	this.creditScore = creditScore;
}
public Date getRegDate() {
	return regDate;
}
public void setRegDate(Date regDate) {
	this.regDate = regDate;
}
public String getAccountStatus() {
	return accountStatus;
}
public void setAccountStatus(String accountStatus) {
	this.accountStatus = accountStatus;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}

}
