package com.oracle.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class DocumentData {
private String loanType;
private List<MultipartFile> file;


public List< MultipartFile> getFile() {
	return file;
}
public void setFile(List<MultipartFile> file) {
	this.file = file;
}

public String getLoanType() {
	return loanType;
}
public void setLoanType(String loanType) {
	this.loanType = loanType;
}


}
