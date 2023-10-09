package com.oracle.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Application {
private String loanType;
private String ApplicationId;
private String programName;
private int applicationStatus;
private long  AmountRequested;
private Date applicationDate;
private String rejectReason;
private float roi;
private int tenure;

public Application() {
}
public Application(String loanType, String applicationId, String programName, int applicationStatus,
		long amountRequested, Date applicationDate, String rejectReason, float roi, int tenure) {
	super();
	this.loanType = loanType;
	ApplicationId = applicationId;
	this.programName = programName;
	this.applicationStatus = applicationStatus;
	AmountRequested = amountRequested;
	this.applicationDate = applicationDate;
	this.rejectReason = rejectReason;
	this.roi = roi;
	this.tenure = tenure;
}
public float getRoi() {
	return roi;
}
public void setRoi(float roi) {
	this.roi = roi;
}
public int getTenure() {
	return tenure;
}
public void setTenure(int tenure) {
	this.tenure = tenure;
}
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
public long getAmountRequested() {
	return AmountRequested;
}
public void setAmountRequested(long amountRequested) {
	AmountRequested = amountRequested;
}
public Date getApplicationDate() {
	return applicationDate;
}
public void setApplicationDate(Date applicationDate) {
	this.applicationDate = applicationDate;
}
public String getRejectReason() {
	return rejectReason;
}
public void setRejectReason(String rejectReason) {
	this.rejectReason = rejectReason;
}
public String getApplicationId() {
	return ApplicationId;
}
public void setApplicationId(String applicationId) {
	ApplicationId = applicationId;
}

}
