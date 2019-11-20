package com.ankit.service.counter.service;

import java.util.List;

import com.ankit.service.counter.model.Status;
import com.ankit.service.counter.response.model.PendingJob;

public interface ServiceCounterService {
	
	public List<PendingJob> getPendingTasks(Long counterId,Long jobStatusId);
	public String completeTask(Long counterId, String tokenNumber,Status doneStatus);

}
