package com.oracle.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.oracle.dto.ApiError;

@RestControllerAdvice

public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleException(Exception e) {
		ApiError error=new ApiError();
		error.setError(e.getMessage());
		error.setStatusCode(404);
		return new ResponseEntity<ApiError>(error , HttpStatusCode.valueOf(404));
	}
}
