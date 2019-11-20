package com.ankit.token.assigner.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ankit.token.assigner.model.CounterType;



public interface CounterTypeRepository extends JpaRepository<CounterType,Long>{
	
	Optional<CounterType> findById(Long typeId);

}
