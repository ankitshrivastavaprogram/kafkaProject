package com.ankit.service.counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BrillioServiceCounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrillioServiceCounterApplication.class, args);
	}

}
