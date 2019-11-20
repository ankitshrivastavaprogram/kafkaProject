package com.ankit.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="counters")
public class Counter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="counter_name")
	private String counterName;
	
	@Column(name="password")
	private String password;
	
	//two types of counter are there : a) for token generation b) for providing service to token
	@OneToOne
	@JoinColumn(name="counter_type")
	private CounterType counterType;

	public Counter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Counter(String counterName, String password) {
		super();
		this.counterName = counterName;
		this.password = password;
	}
	
	

	
	

	public Counter(String counterName, String password, CounterType counterType) {
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

	public Long getId() {
		return id;
	}

	public String getCounterName() {
		return counterName;
	}

	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}

	public CounterType getCounterType() {
		return counterType;
	}

	public void setCounterType(CounterType counterType) {
		this.counterType = counterType;
	}

	
	
	

}








