package com.zensar.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.zensar.demo.dto.CouponDto;
import com.zensar.demo.entity.Coupon;
import com.zensar.demo.exception.CouponNotFound;
import com.zensar.demo.exception.EmptyCouponList;
import com.zensar.demo.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponServices {

	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private ModelMapper modelMapper;

	Pageable p;

	@Override
	public CouponDto getCoupon(int couponId) {
		if (!couponRepository.findById(couponId).isPresent())
			throw new CouponNotFound();
		Coupon coupon = couponRepository.findById(couponId).get();
		return modelMapper.map(coupon, CouponDto.class);
	}

	@Override
	public List<CouponDto> getAllCoupon(int pageNumber, int pageSize, String sortBy, Direction dir) {
		if (couponRepository.findAll().isEmpty())
			throw new EmptyCouponList();
		List<CouponDto> listOfDto = new ArrayList<CouponDto>();
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, dir, sortBy);
		Page<Coupon> page = couponRepository.findAll(pageRequest);
		for (Coupon coupon : page) {
			listOfDto.add(modelMapper.map(coupon, CouponDto.class));
		}
		return listOfDto;

	}

	@Override
	public CouponDto insertCoupon(CouponDto couponDto) {
		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		Coupon coupon2 = couponRepository.save(coupon);
		return modelMapper.map(coupon2, CouponDto.class);

	}

	@Override
	public CouponDto updateCoupon(int couponId, CouponDto couponDto) {
		if (!couponRepository.findById(couponId).isPresent())
			throw new CouponNotFound();
		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		Coupon coupon2 = couponRepository.save(coupon);
		return modelMapper.map(coupon2, CouponDto.class);

	}

	@Override
	public void deleteCoupon(int couponId) {
		couponRepository.deleteById(couponId);
	}

	@Override
	public List<CouponDto> findByPercentDiscount(int percentDiscount) {
		if (couponRepository.findByPercentDiscount(percentDiscount).isEmpty())
			throw new EmptyCouponList();
		List<Coupon> listOfCoupon = couponRepository.findByPercentDiscount(percentDiscount);
		List<CouponDto> listOfDto = new ArrayList<CouponDto>();
		for (Coupon coupon : listOfCoupon) {
			listOfDto.add(modelMapper.map(coupon, CouponDto.class));
		}
		return listOfDto;
	}

	@Override
	public List<CouponDto> findByCouponCodeOrPercentDiscount(int couponCode, int percentDiscount) {
		if (couponRepository.findByCouponCodeOrPercentDiscount(couponCode, percentDiscount).isEmpty())
			throw new EmptyCouponList();
		List<Coupon> listOfCoupon = couponRepository.findByCouponCodeOrPercentDiscount(couponCode, percentDiscount);
		List<CouponDto> listOfDto = new ArrayList<CouponDto>();
		for (Coupon coupon : listOfCoupon) {
			listOfDto.add(modelMapper.map(coupon, CouponDto.class));
		}
		return listOfDto;
	}

	@Override
	public List<CouponDto> test(int percentDiscount) {
		if (couponRepository.test(percentDiscount).isEmpty())
			throw new EmptyCouponList();
		List<Coupon> listOfCoupon = couponRepository.test(percentDiscount);
		List<CouponDto> listOfDto = new ArrayList<CouponDto>();
		for (Coupon coupon : listOfCoupon) {
			listOfDto.add(modelMapper.map(coupon, CouponDto.class));
		}
		return listOfDto;
	}

	@Override
	public List<CouponDto> test2(int couponCode, int percentDiscount) {
		if (couponRepository.test2(couponCode, percentDiscount).isEmpty())
			throw new EmptyCouponList();
		List<Coupon> listOfCoupon = couponRepository.test2(couponCode, percentDiscount);
		List<CouponDto> listOfDto = new ArrayList<CouponDto>();
		for (Coupon coupon : listOfCoupon) {
			listOfDto.add(modelMapper.map(coupon, CouponDto.class));
		}
		return listOfDto;
	}

	@Override
	public List<CouponDto> getByPercentDiscountGreaterThan(int percentDiscount) {
		if (couponRepository.getByPercentDiscountGreaterThan(percentDiscount).isEmpty())
			throw new EmptyCouponList();
		List<Coupon> listOfCoupon = couponRepository.getByPercentDiscountGreaterThan(percentDiscount);
		List<CouponDto> listOfDto = new ArrayList<CouponDto>();
		for (Coupon coupon : listOfCoupon) {
			listOfDto.add(modelMapper.map(coupon, CouponDto.class));
		}
		return listOfDto;
	}

	@Override
	public CouponDto findByCouponCode(int couponCode) {
		Coupon coupon = couponRepository.findByCouponCode(couponCode);
		return modelMapper.map(coupon, CouponDto.class);
	}

}
