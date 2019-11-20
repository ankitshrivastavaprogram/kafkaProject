package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CounterType;

public interface CounterTypeRepository extends JpaRepository<CounterType,Long>{
	
	Optional<CounterType> findById(Long typeId);

}
