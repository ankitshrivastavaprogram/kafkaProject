package com.ankit.admin.service;

import java.util.List;
import com.ankit.admin.dto.RequestCounterDto;
import com.ankit.admin.dto.RequestServiceCounterDto;



public interface CounterService {
	
	
	
	public String create(List<RequestCounterDto> requestCounters);
	
	public String update(Long counterId, RequestServiceCounterDto requestServiceCounter);

}
