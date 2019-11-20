package com.ankit.admin.response.model;

public class ApiResponse {
	
	private String Message;

	public ApiResponse() {
		super();
		
	}

	public ApiResponse(String message) {
		super();
		Message = message;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	

}
