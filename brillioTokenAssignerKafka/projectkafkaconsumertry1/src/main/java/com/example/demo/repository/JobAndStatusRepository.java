package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.JobAndStatus;

public interface JobAndStatusRepository extends JpaRepository<JobAndStatus,Long>{

}

