package com.ankit.service.counter.response.model;

public class PendingJob {
	
	private Long jobId;
	private String tokenNumber;
	private String statusOfJob;
	
	public PendingJob() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PendingJob(Long jobId, String tokenNumber, String statusOfJob) {
		super();
		this.jobId = jobId;
		this.tokenNumber = tokenNumber;
		this.statusOfJob = statusOfJob;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(String tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	public String getStatusOfJob() {
		return statusOfJob;
	}

	public void setStatusOfJob(String statusOfJob) {
		this.statusOfJob = statusOfJob;
	} 
	
	
	
	
	

}
