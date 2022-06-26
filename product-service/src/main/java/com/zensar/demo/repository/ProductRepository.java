package com.zensar.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByProductName(String productName);

	List<Product> findByProductCost(int productCost);

	List<Product> findByProductCostBetween(int productCost1, int productCost2);

	List<Product> findByProductCostGreaterThan(int productCost);

	List<Product> test(String productName);

	List<Product> test2(int productCost);

	List<Product> test3(String productName, int productCost);

	@Query(value = "select * from Product where product_name=:name and product_cost=:cost", nativeQuery = true)
	List<Product> test4(@Param("name") String productName, @Param("cost") int productCost);

}
