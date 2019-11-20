package com.ankit.auth.exception;

public class InvalidCounterTypeException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;
	final private  String message  = "Conter type is invalid";

	public String getMessage() {
		return message;
	}
	
	
	

}
