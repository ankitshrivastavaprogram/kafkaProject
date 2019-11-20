package com.ankit.zuul.exception;

public class InvalidCounterIdException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message = "Counter id is invalid";

	public InvalidCounterIdException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	
	
	

}
