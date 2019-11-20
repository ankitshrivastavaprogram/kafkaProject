package com.ankit.token.assigner.kafka.listener;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;

import com.ankit.token.assigner.kafka.model.KafkaMessage;

public class Receiver {

	  

	  private CountDownLatch latch = new CountDownLatch(1);

	  public CountDownLatch getLatch() {
	    return latch;
	  }

	  @KafkaListener(topics = "kafka_json")
	  public void receive(KafkaMessage car) {
	    System.out.println(car);
	  }
	}
