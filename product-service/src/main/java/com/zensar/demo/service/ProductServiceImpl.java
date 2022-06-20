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
import com.zensar.demo.dto.ProductDto;
import com.zensar.demo.entity.Product;
import com.zensar.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductServices {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	Pageable p;

	@Override
	public ProductDto getProduct(int productId) {

		Product product = productRepository.findById(productId).get();
		return modelMapper.map(product, ProductDto.class);

	}

	@Override
	public List<ProductDto> getAllProduct(int pageNumber, int pageSize, String sortBy, Direction direction) {

		List<ProductDto> listOfDto = new ArrayList<ProductDto>();
		Page<Product> page = productRepository.findAll(PageRequest.of(pageNumber, pageSize, direction, sortBy));
		for (Product product : page) {
			listOfDto.add(modelMapper.map(product, ProductDto.class));
		}
		return listOfDto;

	}

	@Override
	public ProductDto insertProduct(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		Product product2 = productRepository.save(product);
		return modelMapper.map(product2, ProductDto.class);
	}

	@Override
	public void updateProduct(int productId, ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		Product product2 = productRepository.save(product);
		modelMapper.map(product2, ProductDto.class);

	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public List<ProductDto> findByProductName(String productName) {
		List<Product> listOfProduct = productRepository.findByProductName(productName);
		List<ProductDto> lsitOfDto = new ArrayList<ProductDto>();
		for (Product product : listOfProduct) {
			lsitOfDto.add(modelMapper.map(product, ProductDto.class));
		}
		return lsitOfDto;
	}

	@Override
	public List<ProductDto> findByProductCost(int productCost) {
		List<Product> listOfProduct = productRepository.findByProductCost(productCost);
		List<ProductDto> lsitOfDto = new ArrayList<ProductDto>();
		for (Product product : listOfProduct) {
			lsitOfDto.add(modelMapper.map(product, ProductDto.class));
		}
		return lsitOfDto;
	}

	@Override
	public List<ProductDto> findByProductCostBetween(int productCost1, int productCost2) {
		List<Product> listOfProduct = productRepository.findByProductCostBetween(productCost1, productCost2);
		List<ProductDto> lsitOfDto = new ArrayList<ProductDto>();
		for (Product product : listOfProduct) {
			lsitOfDto.add(modelMapper.map(product, ProductDto.class));
		}
		return lsitOfDto;
	}

	@Override
	public List<ProductDto> test(String productName) {
		List<Product> listOfProduct = productRepository.test(productName);
		List<ProductDto> lsitOfDto = new ArrayList<ProductDto>();
		for (Product product : listOfProduct) {
			lsitOfDto.add(modelMapper.map(product, ProductDto.class));
		}
		return lsitOfDto;
	}

	@Override
	public List<ProductDto> test2(int productCost) {
		List<Product> listOfProduct = productRepository.test2(productCost);
		List<ProductDto> lsitOfDto = new ArrayList<ProductDto>();
		for (Product product : listOfProduct) {
			lsitOfDto.add(modelMapper.map(product, ProductDto.class));
		}
		return lsitOfDto;
	}

	@Override
	public List<ProductDto> test3(String productName, int productCost) {
		List<Product> listOfProduct = productRepository.test3(productName, productCost);
		List<ProductDto> lsitOfDto = new ArrayList<ProductDto>();
		for (Product product : listOfProduct) {
			lsitOfDto.add(modelMapper.map(product, ProductDto.class));
		}
		return lsitOfDto;
	}

	@Override
	public List<ProductDto> test4(String productName, int productCost) {
		List<Product> listOfProduct = productRepository.test4(productName, productCost);
		List<ProductDto> lsitOfDto = new ArrayList<ProductDto>();
		for (Product product : listOfProduct) {
			lsitOfDto.add(modelMapper.map(product, ProductDto.class));
		}
		return lsitOfDto;
	}

	@Override
	public List<ProductDto> findByProductCostGreaterThan(int productCost) {
		List<Product> listOfProduct = productRepository.findByProductCostGreaterThan(productCost);
		List<ProductDto> lsitOfDto = new ArrayList<ProductDto>();
		for (Product product : listOfProduct) {
			lsitOfDto.add(modelMapper.map(product, ProductDto.class));
		}
		return lsitOfDto;
	}

}
