package com.example.demo.listener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.kafka.model.KafkaMessage;
import com.example.demo.model.Counter;
import com.example.demo.model.JobAndStatus;
import com.example.demo.model.ServiceCounterDetail;
import com.example.demo.model.ServiceCounterTaskCount;
import com.example.demo.model.Status;
import com.example.demo.model.TokenType;
import com.example.demo.repository.CounterRepository;
import com.example.demo.repository.ServiceCounterDetailRepository;
import com.example.demo.repository.StatusRepository;
import com.example.demo.repository.TokenTypeRepository;


@Service
public class KafkaConsumer {
	
	@Value("${job.status.pending}")
	private String pending;
	
	@Value("${job.status.done}")
	private String done;
	
	@Autowired
	private ServiceCounterDetailRepository serviceCounterDetailRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private CounterRepository counterRepository;
	
	@Autowired
	private TokenTypeRepository tokenTypeRepository;
	
	
	
	@KafkaListener(topics = "kafka_example", groupId = "group_id",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(KafkaMessage kafkaMessage) {
		Long tokenType = kafkaMessage.getTokenType();
		String tokenNumber =  kafkaMessage.getToken(); 
        
        
		  Pageable pageable = PageRequest.of(0,1,Sort.Direction.DESC,"id");
		  List<ServiceCounterDetail> serviceCounterDetails= 
				  serviceCounterDetailRepository
				  .findCountersWithNoTaskAsignYetByTokenType( tokenType,pageable);
		  if(serviceCounterDetails.size()>0) {
			  ServiceCounterDetail serviceCounterDetail = serviceCounterDetails.get(0);
			  Counter c = serviceCounterDetail.getCounter();
			  Status status = statusRepository.findByStatus(pending).get();
			  JobAndStatus jobAndStatus = new JobAndStatus(status, tokenNumber);
			  serviceCounterDetail.setJobAndStatus(jobAndStatus);
			  serviceCounterDetailRepository.save(serviceCounterDetail);
			  
			  
		  }
		  else {
			  System.out.println("comming here");
			  Status status = statusRepository.findByStatus(pending).get();
			  Long pendingJobStatusId = status.getId();
			 
			  List<ServiceCounterTaskCount> serviceCounterTaskCounts= 
					  serviceCounterDetailRepository
					  .findCountersWithMinmumPendingTaskByTokenType( tokenType,pendingJobStatusId);
			  
			  ServiceCounterTaskCount ServiceCounterTaskCount =  serviceCounterTaskCounts.get(0);
			  Long CounterId = ServiceCounterTaskCount.getCounter();
			  Counter counter_ = counterRepository.findById(CounterId).get();
			  
			  
			  System.out.println(counter_.getCounterName()+" aaaaaaaaaaaaaaa "+counter_.getId()+"  bbbbbbbbbb"+counter_.getCounterType());
			  
			  Status status_ = statusRepository.findByStatus(pending).get();
			  JobAndStatus jobAndStatus_ = new JobAndStatus(status_, tokenNumber);
			  TokenType servingTokenType = tokenTypeRepository.findById(tokenType).get();
			  
			 
			  ServiceCounterDetail serviceCounterDetail_ = new ServiceCounterDetail();
			  serviceCounterDetailRepository.save(serviceCounterDetail_);
			  serviceCounterDetail_= serviceCounterDetailRepository.findById(serviceCounterDetail_.getId()).get();
			  serviceCounterDetail_.setCounter(counter_);
			  serviceCounterDetail_.setJobAndStatus(jobAndStatus_);
			  serviceCounterDetail_.setServingTokenType(servingTokenType);
			  serviceCounterDetailRepository.save(serviceCounterDetail_);
			  
			  
		  }
		 
    }

}
