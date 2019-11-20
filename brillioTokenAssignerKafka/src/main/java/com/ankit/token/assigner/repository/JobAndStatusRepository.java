package com.ankit.token.assigner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankit.token.assigner.model.JobAndStatus;



public interface JobAndStatusRepository extends JpaRepository<JobAndStatus,Long>{

}

