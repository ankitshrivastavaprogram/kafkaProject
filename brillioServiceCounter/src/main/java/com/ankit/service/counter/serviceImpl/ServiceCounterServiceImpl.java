package com.ankit.service.counter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankit.service.counter.model.ServiceCounterDetail;
import com.ankit.service.counter.model.Status;
import com.ankit.service.counter.repository.ServiceCounterDetailRepository;
import com.ankit.service.counter.response.model.PendingJob;
import com.ankit.service.counter.service.ServiceCounterService;



@Service
public class ServiceCounterServiceImpl implements ServiceCounterService {
	
	@Autowired
	ServiceCounterDetailRepository serviceCounterDetailRepository;
	
	public List<PendingJob> getPendingTasks(Long counterId,Long jobStatusId){
		
		return serviceCounterDetailRepository.findPendingJobs(counterId,jobStatusId);
		
	}

	public String completeTask(Long counterId, String tokenNumber,Status doneStatus) {
		// TODO Auto-generated method stub
		ServiceCounterDetail serviceCounterDetail = serviceCounterDetailRepository.completeTasktry1(counterId,tokenNumber).get();
		
		serviceCounterDetail.getJobAndStatus().setStatus(doneStatus);
		serviceCounterDetailRepository.save(serviceCounterDetail);
		
		return "job is complete id : "+serviceCounterDetail.getId()+" counter name "+serviceCounterDetail.getCounter().getCounterName()
				+" token number "+ serviceCounterDetail.getJobAndStatus().getTokenNumber()
				+" jobstatus "+serviceCounterDetail.getJobAndStatus().getStatus().getStatus(); 
		
	}

}
