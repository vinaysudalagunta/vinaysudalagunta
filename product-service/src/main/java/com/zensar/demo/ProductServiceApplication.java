package com.zensar.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
@ComponentScan(basePackages = { "test", "com.zensar" })
@EnableEurekaClient
@EnableFeignClients
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);

	}

	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();

	}

	/*
	 * @Bean
	 * 
	 * @LoadBalanced public RestTemplate restTemplate() { return new RestTemplate();
	 * }
	 */

}
