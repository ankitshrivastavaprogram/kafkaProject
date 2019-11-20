package com.ankit.admin.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="service_counter_detail")
public class ServiceCounterDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="counter")
	private Counter counter;
	
	//there are two types of service counter: a) those who will serve only premium token b) those who will serve normal token only
	@OneToOne
	@JoinColumn(name="serving_token_type")
	TokenType servingTokenType;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tasks")
	private JobAndStatus jobAndStatus;
	
	public ServiceCounterDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceCounterDetail(Counter counter, TokenType servingTokenType) {
		super();
		this.counter = counter;		
		this.servingTokenType = servingTokenType;
	}	

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

	public TokenType getServingTokenType() {
		return servingTokenType;
	}

	public void setServingTokenType(TokenType servingTokenType) {
		this.servingTokenType = servingTokenType;
	}

	public Long getId() {
		return id;
	}

	public JobAndStatus getJobAndStatus() {
		return jobAndStatus;
	}

	public void setJobAndStatus(JobAndStatus jobAndStatus) {
		this.jobAndStatus = jobAndStatus;
	}

	
	
	

}
