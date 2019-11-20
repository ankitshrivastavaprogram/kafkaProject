package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.ServiceCounterDetail;
import com.example.demo.model.ServiceCounterTaskCount;

public interface ServiceCounterDetailRepository extends JpaRepository<ServiceCounterDetail,Long>{

	/*
	 * @Query("select c from ServiceCounterDetail c where c.servingTokenType.id = :tokenType"
	 * ) List<ServiceCounterDetail>
	 * findCountersWithMinmumPendingJobByTokenType(@Param("tokenType")Long
	 * tokenType);
	 * 
	 * select NEW ServiceCounterTaskCount(c.counter.id,count(*)) from ServiceCounterDetail c where c.servingTokenType.id = :tokenType group by c.counter.id
	 */
	
	/*
	 * @Query("select NEW com.example.demo.model.ServiceCounterTaskCount(c.counter.id,count(*))"
	 * + " from ServiceCounterDetail c where c.servingTokenType.id = :tokenType " +
	 * "and c.jobAndStatusList = :n " + "group by c.counter.id")
	 * 
	 * List<ServiceCounterTaskCount>
	 * findCountersWithMinmumPendingJobByTokenType(@Param("tokenType")Long
	 * tokenType,@Param("n")Integer n);
	 * 
	 * select c from ServiceCounterDetail as c where c.servingTokenType =1 AND c.jobAndStatusList is null
	 */
	
	
	
	 
	  
	  @Query("select c from ServiceCounterDetail c where c.servingTokenType.id = :tokenType AND c.jobAndStatus is null")
	  List<ServiceCounterDetail> findCountersWithNoTaskAsignYetByTokenType(@Param("tokenType")Long  tokenType, Pageable pageable);
	  
	  
	
	  @Query("select NEW com.example.demo.model.ServiceCounterTaskCount(c.counter.id,count(c.counter.id)) "
	  +
	  " from ServiceCounterDetail c where c.servingTokenType.id = :servingTokenType "
	  + "and c.jobAndStatus.status.id = :jobStatus group by c.counter.id order by count(c.counter.id)")
	  
	  List<ServiceCounterTaskCount>
	  findCountersWithMinmumPendingTaskByTokenType(@Param("servingTokenType")Long servingTokenType,@Param("jobStatus")Long jobStatus);
	  
	 
	 
	 
			 
	 
			  
 
	   
 
	
}

