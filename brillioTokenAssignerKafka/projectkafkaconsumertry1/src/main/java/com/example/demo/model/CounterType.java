package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="counter_type")
public class CounterType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="counter_type")
	private String counterType;

	public CounterType() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getCounterType() {
		return counterType;
	}



	public void setCounterType(String counterType) {
		this.counterType = counterType;
	}



	public Long getId() {
		return id;
	}
	
	

}
