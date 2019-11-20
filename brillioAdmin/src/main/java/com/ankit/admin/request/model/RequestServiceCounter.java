package com.ankit.admin.request.model;

public class RequestServiceCounter {

	
	private Long servingTokenType;
	
	public RequestServiceCounter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestServiceCounter( Long servingTokenType) {
		super();
		
		this.servingTokenType = servingTokenType;
	}

	

	public Long getServingTokenType() {
		return servingTokenType;
	}

	public void setServingTokenType(Long servingTokenType) {
		this.servingTokenType = servingTokenType;
	}
	
	
	
}
