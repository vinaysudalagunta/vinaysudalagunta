package com.zensar.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
@ComponentScan(basePackages = { "test", "com.zensar" })
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);

	}

	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();

	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
