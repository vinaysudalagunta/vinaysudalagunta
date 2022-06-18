package com.zensar.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zensar.demo.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	List<Coupon> findByPercentDiscount(int percentDiscount);

	List<Coupon> findByCouponCodeOrPercentDiscount(int couponCode, int percentDiscount);
	
	List<Coupon> getByPercentDiscountGreaterThan(int percentDiscount);

	@Query("from Coupon c where percentDiscount=?1")
	List<Coupon> test(int percentDiscount);

	@Query(value = "select * from coupon where coupon_code=?1 or percent_discount=?2", nativeQuery = true)
	List<Coupon> test2(int couponCode, int percentDiscount);
}
