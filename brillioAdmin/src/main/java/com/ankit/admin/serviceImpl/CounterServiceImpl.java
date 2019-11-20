package com.ankit.admin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ankit.admin.dto.RequestCounterDto;
import com.ankit.admin.dto.RequestServiceCounterDto;
import com.ankit.admin.model.Counter;
import com.ankit.admin.model.CounterType;
import com.ankit.admin.model.ServiceCounterDetail;
import com.ankit.admin.model.TokenType;
import com.ankit.admin.repository.CounterRepository;
import com.ankit.admin.repository.CounterTypeRepository;
import com.ankit.admin.repository.ServiceCounterDetailRepository;
import com.ankit.admin.repository.TokenTypeRepository;
import com.ankit.admin.service.CounterService;


@Service
public class CounterServiceImpl implements CounterService {
	
	@Autowired
	CounterRepository counterRepository;
	
	@Autowired
	private CounterTypeRepository counterTypeRepository;
	
	@Autowired
	private TokenTypeRepository tokenTypeRepository;
	
	@Autowired
	private ServiceCounterDetailRepository serviceCounterDetailRepository;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	public String create(List<RequestCounterDto> requestCounters) {
		
		for(RequestCounterDto c : requestCounters) {
			
			String counterName = c.getCounterName();
			String password = c.getPassword();
			
			CounterType counterType = counterTypeRepository.getOne(c.getCounterType());
			Counter counter = new Counter(counterName, password, counterType);
			counter.setPassword(passwordEncoder.encode(password));
			counterRepository.save(counter);
			
			if(c.getCounterType()==2) {
				
				 
				  TokenType tokenType = tokenTypeRepository.findById(1L).get();
				 
				  ServiceCounterDetail serviceCounterDetail = new
				  ServiceCounterDetail(counter,tokenType);
				  serviceCounterDetailRepository.save(serviceCounterDetail);
				 
			}
			
		}
		
		
		
		return "counter got saved";
	}
	
	/*
	 * public String update(Long counterId, RequestServiceCounterDto
	 * requestServiceCounter) {
	 * 
	 * ServiceCounterDetail serviceCounterDetail =
	 * serviceCounterDetailRepository.findById(serviceCounterDetailId).get();
	 * TokenType tokenType =
	 * tokenTypeRepository.findById(requestServiceCounter.getServingTokenType()).get
	 * (); serviceCounterDetail.setServingTokenType(tokenType);
	 * serviceCounterDetailRepository.save(serviceCounterDetail);
	 * 
	 * return "counter got updated"; }
	 */
	
	public String update(Long counterId, RequestServiceCounterDto requestServiceCounter) {
		
		/*
		 * ServiceCounterDetail serviceCounterDetail =
		 * serviceCounterDetailRepository.findById(counterId).get(); TokenType tokenType
		 * =
		 * tokenTypeRepository.findById(requestServiceCounter.getServingTokenType()).get
		 * (); serviceCounterDetail.setServingTokenType(tokenType);
		 * serviceCounterDetailRepository.save(serviceCounterDetail);
		 */
		
		serviceCounterDetailRepository.changeServiceWindowType(counterId, 2L);
			
			return "counter got updated";
		}

}
