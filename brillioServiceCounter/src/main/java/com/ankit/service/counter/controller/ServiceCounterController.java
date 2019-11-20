package com.ankit.service.counter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.service.counter.model.Status;
import com.ankit.service.counter.repository.StatusRepository;
import com.ankit.service.counter.request.model.CompletionRequest;
import com.ankit.service.counter.response.model.APIResponse;
import com.ankit.service.counter.response.model.PendingJob;
import com.ankit.service.counter.security.CurrentUser;
import com.ankit.service.counter.security.UserPrincipal;
import com.ankit.service.counter.service.ServiceCounterService;





@RestController
@RequestMapping("/service/counter/")
public class ServiceCounterController {
	
	@Autowired
	ServiceCounterService serviceCounterService;
	
	@Value("${job.status.pending}")
	private String pending;
	
	@Value("${job.status.done}")
	private String done;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@GetMapping("task")
	@PreAuthorize("hasRole('ServiceProvider')")
	public ResponseEntity<List<PendingJob>> getpendingTasks(@CurrentUser UserPrincipal currentUser) {
		
		Long counterId = currentUser.getId();
		System.out.println("aaaaaaaaaaaaaaaaaaa "+counterId);
		  Status status = statusRepository.findByStatus(pending).get();
		  Long statusId = status.getId();
		  List<PendingJob> pendingjobList = serviceCounterService.getPendingTasks(counterId,statusId);
		  
		  
		return new ResponseEntity<List<PendingJob>>(pendingjobList,HttpStatus.OK);
	}
	
	@PostMapping("compleate")
	@PreAuthorize("hasRole('ServiceProvider')")
	public ResponseEntity<APIResponse> compleateTask(@CurrentUser UserPrincipal currentUser,@RequestBody CompletionRequest completionRequest){
		Long counterId = currentUser.getId();
		Status status = statusRepository.findByStatus(done).get();
		Long statusId = status.getId();
		String tokenNumber = completionRequest.getTokenNumber();
		String message = serviceCounterService.completeTask(counterId,tokenNumber,status);
		
		
		return new ResponseEntity<APIResponse>(new APIResponse(message),HttpStatus.OK);
	}
	

}
