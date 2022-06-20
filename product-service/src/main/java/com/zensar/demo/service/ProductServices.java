package com.zensar.demo.service;

import java.util.List;
import org.springframework.data.domain.Sort.Direction;
import com.zensar.demo.dto.ProductDto;
import com.zensar.demo.entity.Product;


public interface ProductServices {

	public ProductDto getProduct(int productId);

	public List<ProductDto> getAllProduct(int pageNumber, int pageSize, String sortBy, Direction direction);

	public ProductDto insertProduct(ProductDto productDto);

	public void updateProduct(int productId, ProductDto productDto);

	public void deleteProduct(int productId);

	List<ProductDto> findByProductName(String productName);

	List<ProductDto> findByProductCost(int productCost);

	List<ProductDto> findByProductCostBetween(int productCost1, int productCost2);
	
	List<ProductDto> findByProductCostGreaterThan(int productCost);

	List<ProductDto> test(String productName);

	List<ProductDto> test2(int productCost);

	List<ProductDto> test3(String productName, int productCost);

	List<ProductDto> test4(String productName, int productCost);

}
