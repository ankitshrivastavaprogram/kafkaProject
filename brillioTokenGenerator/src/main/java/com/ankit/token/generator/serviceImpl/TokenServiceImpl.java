package com.ankit.token.generator.serviceImpl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ankit.token.generator.kafka.model.KafkaMessage;

import com.ankit.token.generator.service.TokenService;


@Service
public class TokenServiceImpl  implements TokenService{

	
	
	
	  @Autowired
	  KafkaTemplate<String, String> kafkaTemplate;
	  
	  private static final String TOPIC = "kafka_example";
	  
	  public String createServiceToken(Long generaterCounterId,Long tokenTypeId) {
	  
	  Date d1 = new Date();
	  String token = d1.toString()+generaterCounterId;
	  KafkaMessage kafkaMessage = new KafkaMessage(tokenTypeId, token);
	  kafkaTemplate.send(TOPIC, kafkaMessage.toString());
	  
	  return token;
	  }
	 
}
