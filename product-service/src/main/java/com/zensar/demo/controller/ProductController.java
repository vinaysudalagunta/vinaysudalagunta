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
import com.zensar.demo.dto.ProductDto;
import com.zensar.demo.service.ProductServices;

@RestController
@RequestMapping(value = "/product-api", produces = { MediaType.APPLICATION_XML_VALUE,
		MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE })
public class ProductController {

	@Autowired
	private ProductServices productServices;

	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") int productId) {

		return new ResponseEntity<ProductDto>(productServices.getProduct(productId), HttpStatus.OK);
	}

	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductDto>> getAllProduct(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "productName") String sortBy,
			@RequestParam(value = "direction", required = false, defaultValue = "ASC") Direction direction) {
		return new ResponseEntity<List<ProductDto>>(
				productServices.getAllProduct(pageNumber, pageSize, sortBy, direction), HttpStatus.OK);
	}

	@PostMapping(value = "/products")
	public ResponseEntity<ProductDto> insertProduct(@RequestBody ProductDto productDto) {
		return new ResponseEntity<ProductDto>(productServices.insertProduct(productDto), HttpStatus.CREATED);
	}

	@PutMapping(value = "/products/{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable("productId") int productId,
			@RequestBody ProductDto productDto) {
		productServices.updateProduct(productId, productDto);
		return new ResponseEntity<String>("Product Updated Successfully", HttpStatus.OK);
	}

	@DeleteMapping("/products/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {
		productServices.deleteProduct(productId);
		return new ResponseEntity<String>("Product Deleted Successfully", HttpStatus.OK);
	}

	@GetMapping(value = "/products/ProductName/{productName}")
	public ResponseEntity<List<ProductDto>> findByProductName(@PathVariable("productName") String productName) {
		return new ResponseEntity<List<ProductDto>>(productServices.findByProductName(productName), HttpStatus.OK);
	}

	@GetMapping(value = "/products/ProductCost/{productCost}")
	public ResponseEntity<List<ProductDto>> findByProductCost(@PathVariable int productCost) {
		return new ResponseEntity<List<ProductDto>>(productServices.findByProductCost(productCost), HttpStatus.OK);
	}

	@GetMapping(value = "/products/ProductCost/{productCost1}/{productCost2}")
	public ResponseEntity<List<ProductDto>> findByProductCostBetween(@PathVariable("productCost1") int productCost1,
			@PathVariable("productCost2") int productCost2) {
		return new ResponseEntity<List<ProductDto>>(
				productServices.findByProductCostBetween(productCost1, productCost2), HttpStatus.OK);
	}

	@GetMapping(value = "/products/test/ProductName/{productName}")
	public ResponseEntity<List<ProductDto>> test(@PathVariable("productName") String productName) {
		return new ResponseEntity<List<ProductDto>>(productServices.test(productName), HttpStatus.OK);
	}

	@GetMapping(value = "/products/test2/ProductCost/{productCost}")
	public ResponseEntity<List<ProductDto>> test2(@PathVariable("productCost") int productCost) {
		return new ResponseEntity<List<ProductDto>>(productServices.test2(productCost), HttpStatus.OK);
	}

	@GetMapping(value = "/products/test3/ProductNameCost/{productName}/{productCost}")
	public ResponseEntity<List<ProductDto>> test3(@PathVariable("productName") String productName,
			@PathVariable("productCost") int productCost) {
		return new ResponseEntity<List<ProductDto>>(productServices.test3(productName, productCost), HttpStatus.OK);
	}

	@GetMapping(value = "/products/test4/ProductNameCost/{productName}/{productCost}")
	public ResponseEntity<List<ProductDto>> test4(@PathVariable("productName") String productName,
			@PathVariable("productCost") int productCost) {
		return new ResponseEntity<List<ProductDto>>(productServices.test3(productName, productCost), HttpStatus.OK);
	}
	
	@GetMapping(value = "/products/ProductCost2/{productCost}")
	public ResponseEntity<List<ProductDto>> findByProductCostGreaterThan(@PathVariable("productCost") int productCost){
		return new ResponseEntity<List<ProductDto>>(productServices.findByProductCostGreaterThan(productCost), HttpStatus.OK);
		
	}
}
