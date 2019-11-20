package com.ankit.admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankit.admin.model.Status;

public interface StatusRepository extends JpaRepository<Status,Long>{
	
	Optional<Status>  findByStatus(String status);

}

