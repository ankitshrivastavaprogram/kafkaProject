package com.ankit.token.assigner.model;

public class ServiceCounterTaskCount {
	
	private Long counter;
	private Long count;
	
	
	
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
	
	
	public Long getCounter() {
		return counter;
	}
	public void setCounter(Long counter) {
		this.counter = counter;
	}
	public ServiceCounterTaskCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServiceCounterTaskCount(Long counter, Long count) {
		super();
		this.counter = counter;
		this.count = count;
	}
	
	
	
	
	
	

}
