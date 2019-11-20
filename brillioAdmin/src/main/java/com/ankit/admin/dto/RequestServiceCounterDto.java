package com.ankit.admin.dto;

public class RequestServiceCounterDto {

	
	private Long servingTokenType;
	
	public RequestServiceCounterDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestServiceCounterDto( Long servingTokenType) {
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
