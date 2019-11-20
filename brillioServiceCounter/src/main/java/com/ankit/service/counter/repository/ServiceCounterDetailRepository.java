package com.ankit.service.counter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ankit.service.counter.model.ServiceCounterDetail;
import com.ankit.service.counter.response.model.PendingJob;




public interface ServiceCounterDetailRepository extends JpaRepository<ServiceCounterDetail,Long>{
	
	@Query("select NEW com.ankit.service.counter.response.model.PendingJob(s.jobAndStatus.id,s.jobAndStatus.tokenNumber,s.jobAndStatus.status.status)"
			+ " from ServiceCounterDetail as s where s.jobAndStatus.status.id = :jobStatusId and s.counter.id = :counterId")
	public List<PendingJob> findPendingJobs(@Param("counterId")Long counterId,@Param("jobStatusId")Long jobStatusId);

	/*
	 * @Transactional
	 * 
	 * @Modifying
	 * 
	 * @Query("UPDATE ServiceCounterDetail s SET s.jobAndStatus.status.id = :doneStatus WHERE s.counter.id = :counterId and s.jobAndStatus.tokenNumber = :tokenNumber"
	 * ) public void completeTask(@Param("counterId")Long
	 * counterId, @Param("tokenNumber") String tokenNumber, @Param("doneStatus")
	 * Long doneStatus);
	 */
	
	@Query("select s from ServiceCounterDetail s  WHERE s.counter.id = :counterId and s.jobAndStatus.tokenNumber = :tokenNumber")
	public Optional<ServiceCounterDetail> completeTasktry1(@Param("counterId")Long counterId, @Param("tokenNumber") String tokenNumber);
	
	
	  @Transactional	  
	  @Modifying	  
	  @Query("UPDATE ServiceCounterDetail s SET s.servingTokenType.id = :tokenTypeId WHERE s.counter.id = :counterId")	  
	  public void changeServiceWindowType(@Param("counterId")Long counterId, @Param("tokenTypeId") Long tokenTypeId);
	 

}

