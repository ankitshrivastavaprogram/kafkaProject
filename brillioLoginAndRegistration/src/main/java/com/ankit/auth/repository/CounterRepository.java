package com.ankit.auth.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ankit.auth.model.Counter;

public interface CounterRepository extends JpaRepository<Counter,Long>{
	
	Optional<Counter> findByCounterName(String counterName);
	Optional<Counter> findById(String counterId);

}
