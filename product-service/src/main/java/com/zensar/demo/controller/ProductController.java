package com.zensar.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.inject.spi.Message;
import com.zensar.demo.dto.CouponDto;
import com.zensar.demo.dto.ProductDto;
import com.zensar.demo.entity.Coupon;
import com.zensar.demo.entity.Product;
import com.zensar.demo.restclient.CouponRestClient;
import com.zensar.demo.service.ProductServices;

import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/product-api")
public class ProductController {

	@Autowired
	private ProductServices productServices;

	/*
	 * @Autowired private RestTemplate restTemplate;
	 */

	@Autowired
	public CouponRestClient couponRestClient;
	
	@Operation(summary = "Product data fetched from DataBase")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Data fatched successfully", content = {
					@Content(mediaType = "application/json"), @Content(mediaType = "application/xml") }),
			@ApiResponse(responseCode = "500", description = "Product Not Avalable", content = @Content) })
	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") int productId) {

		return new ResponseEntity<ProductDto>(productServices.getProduct(productId), HttpStatus.OK);
	}

	@Operation(summary = "Product data fetched from DataBase")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Data fatched successfully", content = {
			@Content(mediaType = "application/json"), @Content(mediaType = "application/xml") }) })
	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductDto>> getAllProduct(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "productName") String sortBy,
			@RequestParam(value = "direction", required = false, defaultValue = "ASC") Direction direction) {
		return new ResponseEntity<List<ProductDto>>(
				productServices.getAllProduct(pageNumber, pageSize, sortBy, direction), HttpStatus.OK);
	}

	@Operation(summary = "Insert Product")
	@PostMapping(value = "/products")
	@Retry(name = "productapi", fallbackMethod = "myFallBackMethod")
	public ProductDto insertProduct(@RequestBody ProductDto productDto) {
		
			//ResponseEntity<CouponDto> responseEntity = restTemplate.getForEntity( "http://COUPON-SERVICE/coupon-api/coupon/couponCode/" + productDto.getCouponCode(), CouponDto.class);
			//int percentDiscount = responseEntity.getBody().getPercentDiscount();
			
			Coupon coupon = couponRestClient.getCoupon(productDto.getCouponCode());
			int percentDiscount = coupon.getPercentDiscount();
			
			productDto.setProductCost(productDto.getProductCost() * (100 - percentDiscount) / 100);

		// int couponId = responseEntity.getBody().getCouponId();
		// restTemplate.delete("http://COUPON-SERVICE/coupon-api/coupon/" + couponId);

		return productServices.insertProduct(productDto);
	}
	
	public ProductDto myFallBackMethod(Throwable t) {
		return new ProductDto();
	}

	@Operation(summary = "Update Product")
	@PutMapping(value = "/products/{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable("productId") int productId,
			@RequestBody ProductDto productDto) {
		productServices.updateProduct(productId, productDto);
		return new ResponseEntity<String>("Product Updated Successfully", HttpStatus.OK);
	}

	@Operation(summary = "Delete Product")
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {
		productServices.deleteProduct(productId);
		return new ResponseEntity<String>("Product Deleted Successfully", HttpStatus.OK);
	}

	@Operation(summary = "Find Product by its name")
	@GetMapping(value = "/products/ProductName/{productName}")
	public ResponseEntity<List<ProductDto>> findByProductName(@PathVariable("productName") String productName) {
		return new ResponseEntity<List<ProductDto>>(productServices.findByProductName(productName), HttpStatus.OK);
	}

	@Operation(summary = "Find Product by its cost")
	@GetMapping(value = "/products/ProductCost/{productCost}")
	public ResponseEntity<List<ProductDto>> findByProductCost(@PathVariable int productCost) {
		return new ResponseEntity<List<ProductDto>>(productServices.findByProductCost(productCost), HttpStatus.OK);
	}

	@Operation(summary = "Find Product with in range of cost")
	@GetMapping(value = "/products/ProductCost/{productCost1}/{productCost2}")
	public ResponseEntity<List<ProductDto>> findByProductCostBetween(@PathVariable("productCost1") int productCost1,
			@PathVariable("productCost2") int productCost2) {
		return new ResponseEntity<List<ProductDto>>(
				productServices.findByProductCostBetween(productCost1, productCost2), HttpStatus.OK);
	}

	@Operation(summary = "Find Product by its name")
	@GetMapping(value = "/products/test/ProductName/{productName}")
	public ResponseEntity<List<ProductDto>> test(@PathVariable("productName") String productName) {
		return new ResponseEntity<List<ProductDto>>(productServices.test(productName), HttpStatus.OK);
	}

	@Operation(summary = "Find all Product having cost greater than supplied cost")
	@GetMapping(value = "/products/test2/ProductCost/{productCost}")
	public ResponseEntity<List<ProductDto>> test2(@PathVariable("productCost") int productCost) {
		return new ResponseEntity<List<ProductDto>>(productServices.test2(productCost), HttpStatus.OK);
	}

	@Operation(summary = "Find Product by name or cost")
	@GetMapping(value = "/products/test3/ProductNameCost/{productName}/{productCost}")
	public ResponseEntity<List<ProductDto>> test3(@PathVariable("productName") String productName,
			@PathVariable("productCost") int productCost) {
		return new ResponseEntity<List<ProductDto>>(productServices.test3(productName, productCost), HttpStatus.OK);
	}

	@Operation(summary = "Find Product by name and cost")
	@GetMapping(value = "/products/test4/ProductNameCost/{productName}/{productCost}")
	public ResponseEntity<List<ProductDto>> test4(@PathVariable("productName") String productName,
			@PathVariable("productCost") int productCost) {
		return new ResponseEntity<List<ProductDto>>(productServices.test3(productName, productCost), HttpStatus.OK);
	}

	@Operation(summary = "Find all Product having cost greater than supplied cost")
	@GetMapping(value = "/products/ProductCost2/{productCost}")
	public ResponseEntity<List<ProductDto>> findByProductCostGreaterThan(@PathVariable("productCost") int productCost) {
		return new ResponseEntity<List<ProductDto>>(productServices.findByProductCostGreaterThan(productCost),
				HttpStatus.OK);

	}
}
