package com.ankit.auth.service.impls;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ankit.auth.dto.AdminDto;
import com.ankit.auth.exception.InvalidCounterTypeException;
import com.ankit.auth.model.Counter;
import com.ankit.auth.model.CounterType;
import com.ankit.auth.repository.CounterRepository;
import com.ankit.auth.repository.CounterTypeRepository;
import com.ankit.auth.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	CounterRepository counterRepository;
	
	@Autowired
	CounterTypeRepository counterTypeRepository;	
	
	@Autowired
    public PasswordEncoder passwordEncoder;
	
	public AdminDto createAdmin(AdminDto adminDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		Counter counter =  modelMapper.map(adminDto, Counter.class);
		Long counterTypeId = adminDto.getCounterType();
		CounterType counterType = counterTypeRepository.findById(counterTypeId).orElseThrow(()->new InvalidCounterTypeException());
		counter.setCounterType(counterType);
		counter.setPassword(passwordEncoder.encode(counter.getPassword()));
		counterRepository.save(counter);
		return adminDto;
	}

}
