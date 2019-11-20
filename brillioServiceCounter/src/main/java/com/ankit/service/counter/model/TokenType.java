package com.ankit.service.counter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="token_type")
public class TokenType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="token_type")
	private String tokenType;

	public TokenType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TokenType(String tokenType) {
		super();
		this.tokenType = tokenType;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Long getId() {
		return id;
	}
	
	

}
