package com.read.reviews.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.read.reviews.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value= {IllegalArgumentException.class, IllegalStateException.class})
	protected ResponseEntity<Object> handleException(RuntimeException ex,WebRequest request){
		 String responseBody = "Exception happened while performing action !"+ ex.getMessage();
		return handleExceptionInternal(ex, responseBody, new HttpHeaders(), HttpStatus.CONFLICT, request);
		
	}
	
	@ExceptionHandler(value= {ResourceNotFoundException.class})
	protected ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex,WebRequest request){
		 String responseBody =  ex.getMessage();
		return handleExceptionInternal(ex, responseBody, new HttpHeaders(), HttpStatus.CONFLICT, request);
		
	}
	
}
