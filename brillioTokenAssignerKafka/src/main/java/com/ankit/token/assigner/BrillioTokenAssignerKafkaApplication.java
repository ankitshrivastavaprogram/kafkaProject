package com.ankit.token.assigner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;


//@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
@SpringBootApplication
public class BrillioTokenAssignerKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrillioTokenAssignerKafkaApplication.class, args);
	}

}
