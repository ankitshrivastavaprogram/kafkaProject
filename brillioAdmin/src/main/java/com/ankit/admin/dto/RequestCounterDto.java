package com.ankit.admin.dto;

public class RequestCounterDto {	
	
	private String counterName;	
	private String password;	
	private Long counterType;

	public RequestCounterDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestCounterDto(String counterName, String password) {
		super();
		this.counterName = counterName;
		this.password = password;
	}
	
	

	
	

	public RequestCounterDto(String counterName, String password, Long counterType) {
		super();
		this.counterName = counterName;
		this.password = password;
		this.counterType = counterType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getCounterName() {
		return counterName;
	}

	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}

	public Long getCounterType() {
		return counterType;
	}

	public void setCounterType(Long counterType) {
		this.counterType = counterType;
	}

	
	
	

}

