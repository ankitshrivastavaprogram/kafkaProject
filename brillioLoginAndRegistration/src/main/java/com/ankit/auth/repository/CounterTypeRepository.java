package com.ankit.auth.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ankit.auth.model.CounterType;



public interface CounterTypeRepository extends JpaRepository<CounterType,Long>{
	
	Optional<CounterType> findById(Long typeId);

}
