package com.ankit.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;




@SpringBootApplication
@EnableDiscoveryClient
public class BrillioLoginAndRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrillioLoginAndRegistrationApplication.class, args);
	}
	
	


}
