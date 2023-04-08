package com.adobe.exceptions;


import java.time.LocalDateTime;

import org.springframework.beans.factory.support.BeanDefinitionValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PostException.class)
	public ResponseEntity<ErrorDetails> ecommerseExceptionHandler(PostException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> ecommerseExceptionHandler(UserException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(BeanDefinitionValidationException.class)
	public ResponseEntity<ErrorDetails> ecommerseExceptionHandler(BeanDefinitionValidationException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDetails> ecommerseExceptionHandler(IllegalArgumentException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> ecommerseExceptionHandler(NoHandlerFoundException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> ecommerseExceptionHandler(MethodArgumentNotValidException ee){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),"Validation Error", ee.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> ecommerseExceptionHandler(Exception ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
}
