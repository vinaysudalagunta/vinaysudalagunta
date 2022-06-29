package com.zensar.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
@EnableEurekaClient
@RestController
@RefreshScope
public class CouponServiceApplication {

	@Value("${test.myLanguage}")
	public String language;
	
	@Autowired
	private MyConfig config;
	
	public static void main(String[] args) {
		SpringApplication.run(CouponServiceApplication.class, args);
	}

	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}
	
	@GetMapping("/")
	public String testConfig() {
		return "Your Language is "+ language + " and testProperty value is "+ config.getTestProperty();
	}
}
