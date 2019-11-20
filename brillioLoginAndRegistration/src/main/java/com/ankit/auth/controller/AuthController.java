package com.ankit.auth.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.auth.dto.AdminDto;
import com.ankit.auth.model.Counter;
import com.ankit.auth.repository.CounterRepository;
import com.ankit.auth.request.model.AdminRequestModel;
import com.ankit.auth.request.model.LoginRequestModel;
import com.ankit.auth.response.model.JwtAuthenticationResponseModel;
import com.ankit.auth.security.JwtTokenProvider;
import com.ankit.auth.service.AdminService;

@RestController
@RequestMapping("/auth/")
public class AuthController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	CounterRepository counterRepository;
	
	@Autowired
    JwtTokenProvider tokenProvider;
	
	@Autowired
    AuthenticationManager authenticationManager;
	
	@GetMapping("status/check")
	public String check() {
		return "ooooooooooooooooo its working!!!";
	}
	
	@PostMapping("registration")
	public ResponseEntity<AdminDto> registration(@RequestBody AdminRequestModel adminDetail) {
		ModelMapper modelMapper = new ModelMapper();
		AdminDto adminDto =  modelMapper.map(adminDetail, AdminDto.class);
		adminService.createAdmin(adminDto);
		return new ResponseEntity<AdminDto>(adminDto,HttpStatus.CREATED);
	}
	
	 @PostMapping("signin")
	    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestModel loginRequest) {

	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginRequest.getCounterName(),
	                        loginRequest.getPassword()
	                )
	        );

	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        Counter counter = counterRepository.findByCounterName(loginRequest.getCounterName()).get();
	        String jwt = tokenProvider.generateToken(counter.getId());
	        return ResponseEntity.ok(new JwtAuthenticationResponseModel(jwt));
	    }

}
