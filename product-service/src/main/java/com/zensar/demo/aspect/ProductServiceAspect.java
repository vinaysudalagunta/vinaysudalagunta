package com.zensar.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductServiceAspect {

	@Before(value = "execution(* com.zensar.demo.service.ProductServiceImpl.*(..)) and args(productId)")
	public void beforeAdvice(JoinPoint joinPoint, int productId) {
		System.out.println("Before Method: "+ joinPoint.getSignature());
	}
	
	@After(value = "execution(* com.zensar.demo.service.ProductServiceImpl.*(..)) and args(productId, productDto)")
	public void afterAdvice(JoinPoint joinPoint, Object productId, Object productDto) {
		System.out.println("After Method: "+ joinPoint.getSignature());
	}
	
	@Before(value = "execution(* com.zensar.demo.service.ProductServiceImpl.*(..)) and args(productName)")
	public void beforeAdvice(JoinPoint joinPoint, String productName) {
		System.out.println("Before Method: "+ joinPoint.getSignature());
	}
	
	
	
}
