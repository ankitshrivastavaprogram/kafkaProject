package com.ankit.token.generator.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.ankit.token.generator.kafka.model.KafkaMessage;




@Configuration
public class KafkaConfig {
	
	
	  @Bean public ProducerFactory<String,String> producerFactory() {
	  
	  Map<String,Object> configs = new HashMap<String,Object>();
	  configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	  configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	  configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class); 
	  return new DefaultKafkaProducerFactory<String,
	  String>(configs ); 
	  }
	  
	  @Bean KafkaTemplate<String, String> kafkaTemplate(){
	  
	  return new KafkaTemplate<>(producerFactory()); }
	 
	
	
	/*
	 * @Bean public ProducerFactory<String,KafkaMessage> producerFactory() {
	 * 
	 * Map<String,Object> configs = new HashMap<>();
	 * configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	 * configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	 * StringSerializer.class);
	 * configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	 * JsonSerializer.class); return new DefaultKafkaProducerFactory<>(configs); }
	 * 
	 * @Bean KafkaTemplate<String, KafkaMessage> kafkaTemplate(){
	 * 
	 * return new KafkaTemplate<>(producerFactory()); }
	 */
}

