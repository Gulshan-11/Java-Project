package com.oracle.entity;

import java.time.LocalDate;

public class ActiveLoans {
private int loanId;
private String type;
private String programeName;
private int roi;
private int tenure;
private long amountSanctioned;
private LocalDate date;
private long amountPaid;
private String approverName;
private long emisPaid;
public int getLoanId() {
	return loanId;
}
public void setLoanId(int loanId) {
	this.loanId = loanId;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getProgrameName() {
	return programeName;
}
public void setProgrameName(String programeName) {
	this.programeName = programeName;
}
public int getRoi() {
	return roi;
}
public void setRoi(int roi) {
	this.roi = roi;
}
public int getTenure() {
	return tenure;
}
public void setTenure(int tenure) {
	this.tenure = tenure;
}
public long getAmountSanctioned() {
	return amountSanctioned;
}
public void setAmountSanctioned(long amountSanctioned) {
	this.amountSanctioned = amountSanctioned;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public long getAmountPaid() {
	return amountPaid;
}
public void setAmountPaid(long amountPaid) {
	this.amountPaid = amountPaid;
}
public String getApproverName() {
	return approverName;
}
public void setApproverName(String approverName) {
	this.approverName = approverName;
}
public long getEmisPaid() {
	return emisPaid;
}
public void setEmisPaid(long emisPaid) {
	this.emisPaid = emisPaid;
}


}
