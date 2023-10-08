package com.oracle.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class DocumentData {
private String loanType;
private List<FileDto> file;


public List<FileDto> getFile() {
	return file;
}
public void setFile(List<FileDto> file) {
	this.file = file;
}

public String getLoanType() {
	return loanType;
}
public void setLoanType(String loanType) {
	this.loanType = loanType;
}


}
