package com.onlinevegetableshopping.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.java.Log;

@ControllerAdvice
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomerExceptionHandler.class);
	
	@ExceptionHandler(VegetableIdNotFoundException.class)
	public ResponseEntity<Object> handleVegetableIdNotFoundException(){
		LOG.error("handleVegetableIdNotFoundException");
		return new ResponseEntity<Object>("Given vegetable id not present in store",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderIdNotFoundException.class)
	public ResponseEntity<Object> handleOrderIdNotFoundException(){
		LOG.error("handleOrderIdNotFoundException");
		return new ResponseEntity<Object>("Please enter valid order id",HttpStatus.BAD_REQUEST);
	}
     
	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<Object> handleUserIdNotFoundException(){
		LOG.error("handleUserIdNotFoundException");
		return new ResponseEntity<Object>("Please enter valid user id, user is not registered ",HttpStatus.BAD_REQUEST);
	}


}
