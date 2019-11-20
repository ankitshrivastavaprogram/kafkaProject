package com.ankit.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.admin.dto.RequestCounterDto;
import com.ankit.admin.dto.RequestServiceCounterDto;
import com.ankit.admin.request.model.RequestCounter;
import com.ankit.admin.request.model.RequestServiceCounter;
import com.ankit.admin.response.model.ApiResponse;
import com.ankit.admin.security.CurrentUser;
import com.ankit.admin.security.UserPrincipal;
import com.ankit.admin.service.CounterService;


@RestController
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	CounterService counterService;
	
	
	@GetMapping("status/check")
	public String check() {
		return "Admin controller is working its working!!!";
	}
	
	
	@GetMapping("current/user")
	@PreAuthorize("hasRole('ADMIN')")
	public String getCurrentUser(@CurrentUser UserPrincipal currentUser) {		
		Long counterId = currentUser.getId();
		return "Id of current user is "+counterId;
	}
	
	@PostMapping("counter")
	@PreAuthorize("hasRole('ADMIN')")	
	public ResponseEntity<ApiResponse> createCounter(@RequestBody List<RequestCounter> requestCounters) {
		
		ModelMapper modelMapper = new ModelMapper();
		List<RequestCounterDto> requestCounterDtos = new ArrayList<RequestCounterDto>();
		
		for(RequestCounter requestCounter : requestCounters) {
			
			RequestCounterDto requestCounterDto = modelMapper.map(requestCounter, RequestCounterDto.class);
			requestCounterDtos.add(requestCounterDto);
			
		}
		
		counterService.create(requestCounterDtos);
		return new ResponseEntity<ApiResponse>(new ApiResponse("conters got created with defalt type:Normal"),HttpStatus.CREATED);
	}
	
	@PutMapping("counter/{counterId}")
	@PreAuthorize("hasRole('ADMIN')")	
	public String update(@PathVariable Long counterId,@RequestBody RequestServiceCounter requestServiceCounter) {
		
		ModelMapper modelMapper = new ModelMapper();
		RequestServiceCounterDto requestServiceCounterDto = modelMapper.map(requestServiceCounter, RequestServiceCounterDto.class);		
		return counterService.update(counterId,requestServiceCounterDto);
	}

}
