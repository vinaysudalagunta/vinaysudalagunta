package com.zensar.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = { @NamedQuery(name = "Product.test", query = "from Product p where p.productName=?1"),
		@NamedQuery(name = "Product.test2", query = "from Product p where p.productPrize>?1") })
@NamedNativeQuery(name = "Product.test3", query = "select * from Product where product_name=?1 or product_prize=?2", resultClass = Product.class)
public class Product {

	@Id
	private int productId;
	private String productName;
	private int productPrize;

	public Product() {
		super();
	}

	public Product(int productId, String productName, int productCost) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrize = productPrize;
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

	public int getProductPrize() {
		return productPrize;
	}

	public void setProductCost(int productCost) {
		this.productPrize = productPrize;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrize=" + productPrize
				+ "]";
	}

}
