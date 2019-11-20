package com.ankit.token.generator.kafka.model;

import java.io.Serializable;

public class KafkaMessage implements Serializable
{

	private static final long serialVersionUID = 1L;
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
	@Override
	public String toString() {
		return tokenType + "," + token ;
	}
	

}
