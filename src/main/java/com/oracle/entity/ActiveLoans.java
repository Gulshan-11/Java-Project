package com.oracle.entity;

import java.sql.Date;
import java.time.LocalDate;

public class ActiveLoans {
private long loanId;
private String type;
private String programeName;
private float roi;
private int tenure;
private long amountSanctioned;
private Date date;
private long amountPaid;
private String approverName;
private long emisPaid;
public long getLoanId() {
	return loanId;
}
public void setLoanId(long l) {
	this.loanId = l;
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
public long getAmountSanctioned() {
	return amountSanctioned;
}
public void setAmountSanctioned(long amountSanctioned) {
	this.amountSanctioned = amountSanctioned;
}
public Date getDate() {
	return date;
}
public void setDate(Date date2) {
	this.date = date2;
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
