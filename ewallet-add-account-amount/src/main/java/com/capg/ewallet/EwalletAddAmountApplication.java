package com.capg.ewallet;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EwalletAddAmountApplication {

	public static void main(String[] args) {
		SpringApplication.run(EwalletAddAmountApplication.class, args);
	}
@Bean
public Random generate()
{
return new Random();	
}
}
