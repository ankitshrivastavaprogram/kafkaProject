package com.ankit.service.counter.request.model;

public class CompletionRequest {
	
   private	String tokenNumber;

public CompletionRequest() {
	super();
	// TODO Auto-generated constructor stub
}

public CompletionRequest(String tokenNumber) {
	super();
	this.tokenNumber = tokenNumber;
}

public String getTokenNumber() {
	return tokenNumber;
}

public void setTokenNumber(String tokenNumber) {
	this.tokenNumber = tokenNumber;
}
   
   

}
