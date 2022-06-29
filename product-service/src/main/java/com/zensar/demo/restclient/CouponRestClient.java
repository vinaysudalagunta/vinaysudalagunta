package com.zensar.demo.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.zensar.demo.entity.Coupon;

@FeignClient("GATEWAY-SERVER")
public interface CouponRestClient {

	
	@GetMapping("/coupon-api/coupon/couponCode/{couponCode}")
	Coupon getCoupon(@PathVariable ("couponCode") int couponCode);

}
