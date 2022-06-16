package com.zensar.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zensar.demo.Repository.CouponRepository;
import com.zensar.demo.dto.CouponDto;
import com.zensar.demo.entity.Coupon;

@Service
public class CouponServiceImpl implements CouponServices {

	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CouponDto getCoupon(int couponId) {

		Coupon coupon = couponRepository.findById(couponId).get();
		//CouponDto couponDto = mapToDto(coupon);
		//return couponDto;

		return modelMapper.map(coupon, CouponDto.class);
	}

	@Override
	public List<CouponDto> getAllCoupon() {
		List<Coupon> listOfCoupon = couponRepository.findAll();
		List<CouponDto> listOfDto = new ArrayList<CouponDto>();
		for (Coupon coupon : listOfCoupon) {
			//CouponDto couponDto = mapToDto(coupon);
			//listOfDto.add(couponDto);
			listOfDto.add(modelMapper.map(coupon, CouponDto.class));
		}
		return listOfDto;
		
		
		
	}

	@Override
	public CouponDto insertCoupon(CouponDto couponDto) {

		//Coupon coupon = mapToentity(couponDto);
		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		Coupon coupon2 = couponRepository.save(coupon);
		//CouponDto couponDto2 = mapToDto(coupon2);
		//return couponDto2;
		return modelMapper.map(coupon2, CouponDto.class);
		

	}

	@Override
	public CouponDto updateCoupon(int couponId, CouponDto couponDto) {

		//Coupon coupon = mapToentity(couponDto);
		
		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		Coupon coupon2 = couponRepository.save(coupon);
		//CouponDto couponDto2 = mapToDto(coupon2);
		return modelMapper.map(coupon2, CouponDto.class);
		//return couponDto2;

	}
	
	

	@Override
	public void deleteCoupon(int couponId) {
		couponRepository.deleteById(couponId);
	}
	
	
/*
	public Coupon mapToentity(CouponDto couponDto) {

		Coupon coupon = new Coupon();
		coupon.setCouponId(couponDto.getCouponId());
		coupon.setCouponCode(couponDto.getCouponCode());
		coupon.setPercentDiscount(couponDto.getPercentDiscount());
		coupon.setExpiryDate(couponDto.getExpiryDate());

		return coupon;

	}

	public CouponDto mapToDto(Coupon coupon) {

		CouponDto couponDto = new CouponDto();
		couponDto.setCouponId(coupon.getCouponId());
		couponDto.setCouponCode(coupon.getCouponCode());
		couponDto.setPercentDiscount(coupon.getPercentDiscount());
		couponDto.setExpiryDate(coupon.getExpiryDate());
		return couponDto;
	}
*/
	
	
	
}
