package com.ankit.auth.dto;

public class AdminDto {
	
	private String counterName;	
	private String password;	
	private Long counterType;
	public String getCounterName() {
		return counterName;
	}
	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getCounterType() {
		return counterType;
	}
	public void setCounterType(Long counterType) {
		this.counterType = counterType;
	}
	
	

}
