package com.oracle.entity;

import java.sql.Timestamp;

public class Transaction {
private long loanId;
private String transactionId;
private Timestamp timestamp ;
private long amountPaid;
public long getLoanId() {
	return loanId;
}
public void setLoanId(long loanId) {
	this.loanId = loanId;
}
public String getTransactionId() {
	return transactionId;
}
public void setTransactionId(String transactionId) {
	this.transactionId = transactionId;
}
public Timestamp getTimestamp() {
	return timestamp;
}
public void setTimestamp(Timestamp timestamp) {
	this.timestamp = timestamp;
}
public long getAmountPaid() {
	return amountPaid;
}
public void setAmountPaid(long amountPaid) {
	this.amountPaid = amountPaid;
}


	
}
