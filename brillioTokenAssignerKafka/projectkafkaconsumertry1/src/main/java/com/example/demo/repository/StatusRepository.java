package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Status;



public interface StatusRepository extends JpaRepository<Status,Long>{
	
	Optional<Status>  findByStatus(String status);

}

