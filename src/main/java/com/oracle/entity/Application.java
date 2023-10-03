package com.oracle.entity;

import java.time.LocalDate;

public class Application {
private String loanType;
private String programName;
private int applicationStatus;
private String  AmountRequested;
private LocalDate applicationDate;
private String rejectReason;
public String getLoanType() {
	return loanType;
}
public void setLoanType(String loanType) {
	this.loanType = loanType;
}
public String getProgramName() {
	return programName;
}
public void setProgramName(String programName) {
	this.programName = programName;
}
public int getApplicationStatus() {
	return applicationStatus;
}
public void setApplicationStatus(int applicationStatus) {
	this.applicationStatus = applicationStatus;
}
public String getAmountRequested() {
	return AmountRequested;
}
public void setAmountRequested(String amountRequested) {
	AmountRequested = amountRequested;
}
public LocalDate getApplicationDate() {
	return applicationDate;
}
public void setApplicationDate(LocalDate applicationDate) {
	this.applicationDate = applicationDate;
}
public String getRejectReason() {
	return rejectReason;
}
public void setRejectReason(String rejectReason) {
	this.rejectReason = rejectReason;
}


}
