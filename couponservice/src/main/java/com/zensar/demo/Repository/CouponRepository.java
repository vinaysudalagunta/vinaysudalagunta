package com.zensar.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.demo.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

}

