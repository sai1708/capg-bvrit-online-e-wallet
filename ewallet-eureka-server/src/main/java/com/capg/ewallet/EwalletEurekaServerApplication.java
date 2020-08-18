package com.capg.ewallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class EwalletEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EwalletEurekaServerApplication.class, args);
	}

}
