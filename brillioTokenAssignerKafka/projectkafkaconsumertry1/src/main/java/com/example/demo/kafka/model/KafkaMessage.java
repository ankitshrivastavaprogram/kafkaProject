package com.example.demo.kafka.model;

public class KafkaMessage {
	
	private Long tokenType;
	private String token;
	public KafkaMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KafkaMessage(Long tokenType, String token) {
		super();
		this.tokenType = tokenType;
		this.token = token;
	}
	public Long getTokenType() {
		return tokenType;
	}
	public void setTokenType(Long tokenType) {
		this.tokenType = tokenType;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	

}
