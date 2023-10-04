package com.oracle.entity;





public class pdfDocument {

	private String customer_id;
	private String loan_type;	

	private byte[] pdfData;
	public pdfDocument() {
		
	}
	
	public pdfDocument(String customerId, String loan_type, byte[] pdfData) {
		super();
		this.customer_id = customerId;
		this.loan_type = loan_type;		
		this.pdfData = pdfData;
	}

	public String getCustomerId() {
		return customer_id;
	}
	public void setCustomerId(String customerId) {
		this.customer_id = customerId;
	}
	
	
	
	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}

	public byte[] getPdfData() {
		return pdfData;
	}
	public void setPdfData(byte[] pdfData) {
		this.pdfData = pdfData;
	}
	
}
