package com.zensar.demo.dto;

import javax.persistence.Transient;

public class ProductDto {
	private int productId;
	private String productName;
	private int productCost;

	@Transient
	private int couponCode;

	public ProductDto() {
		super();
	}

	public ProductDto(int productId, String productName, int productCost) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
	}

	public ProductDto(int productId, String productName, int productCost, int couponCode) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.couponCode = couponCode;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	public int getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(int couponCode) {
		this.couponCode = couponCode;
	}

	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", couponCode=" + couponCode + "]";
	}

}
