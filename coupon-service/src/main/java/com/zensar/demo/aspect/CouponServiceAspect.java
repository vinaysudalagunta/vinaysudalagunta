package com.zensar.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CouponServiceAspect {

	@Before(value = "execution(* com.zensar.demo.service.CouponServiceImpl.*(..)) and args(couponId)")
	public void beforeAdvice(JoinPoint joinPoint, int couponId) {
		System.out.println("Before Method: "+ joinPoint.getSignature());
	}
	
	@After(value = "execution(* com.zensar.demo.service.CouponServiceImpl.*(..)) and args(couponId, couponDto)")
	public void afterAdvice(JoinPoint joinPoint, Object couponId, Object couponDto) {
		System.out.println("After Method: "+ joinPoint.getSignature());
	}
	
	
	@Before(value = "execution(* com.zensar.demo.service.CouponServiceImpl.*(..)) and args(couponId1, couponId2)")
	public void beforeAdvice(JoinPoint joinPoint, int couponId1, int couponId2) {
		System.out.println("Before Method: "+ joinPoint.getSignature());
	}
	
	
	
}
