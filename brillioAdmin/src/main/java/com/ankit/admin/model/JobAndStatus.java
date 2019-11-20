package com.ankit.admin.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="job_status")
public class JobAndStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@OneToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="status")
	private Status status;
	
	@Column(name="token_number")
	private String tokenNumber;
	
	

	public JobAndStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobAndStatus(Status status, String tokenNumber) {
		super();
		this.status = status;
		this.tokenNumber = tokenNumber;
		
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(String tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	
	

	public Long getId() {
		return id;
	}

	
	
	

}
