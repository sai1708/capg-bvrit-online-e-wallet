package com.capg.ewallet;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EwalletAddAmountApplication {

	public static void main(String[] args) {
		SpringApplication.run(EwalletAddAmountApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplateBean() {
		return new RestTemplate();
		}
	
@Bean
public Random generate()
{
return new Random();	
}
}
