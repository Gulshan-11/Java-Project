package com.oracle.exceptions;

public class ApplicationException extends RuntimeException{
public ApplicationException() {
		
	}
	public ApplicationException(String msg) {
		super(msg);
	}

}
