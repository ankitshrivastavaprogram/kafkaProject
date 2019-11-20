package com.ankit.service.counter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankit.service.counter.model.Status;



public interface StatusRepository extends JpaRepository<Status,Long>{
	
	Optional<Status>  findByStatus(String status);

}

