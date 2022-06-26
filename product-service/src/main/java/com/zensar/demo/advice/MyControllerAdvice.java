package com.zensar.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.zensar.demo.exception.EmptyProductList;
import com.zensar.demo.exception.ProductNotFound;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(ProductNotFound.class)
	public ResponseEntity<String> studentNotFound(ProductNotFound exception) {
		return new ResponseEntity<String>("Product is not available, please check again your Database",
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmptyProductList.class)
	public ResponseEntity<String> emptyStudentList(EmptyProductList exception) {
		return new ResponseEntity<String>("Empty Product List", HttpStatus.BAD_REQUEST);
	}

}
