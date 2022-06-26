package com.zensar.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.zensar.demo.exception.CouponNotFound;
import com.zensar.demo.exception.EmptyCouponList;



@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(CouponNotFound.class)
	public ResponseEntity<String> couponNotFound(CouponNotFound exception) {
		return new ResponseEntity<String>("Coupon is not available, please check again your Database",
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmptyCouponList.class)
	public ResponseEntity<String> emptyCouponList(EmptyCouponList exception) {
		return new ResponseEntity<String>("Empty Coupon List", HttpStatus.BAD_REQUEST);
	}

}
