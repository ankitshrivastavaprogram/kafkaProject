package com.ankit.auth.request.model;

import javax.validation.constraints.NotBlank;
public class LoginRequestModel {
	
	@NotBlank
    private String counterName;

    @NotBlank
    private String password;

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

}
