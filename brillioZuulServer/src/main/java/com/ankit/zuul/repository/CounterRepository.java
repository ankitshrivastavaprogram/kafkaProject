package com.ankit.zuul.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ankit.zuul.model.Counter;

public interface CounterRepository extends JpaRepository<Counter,Long>{
	
	Optional<Counter> findByCounterName(String counterName);
	Optional<Counter> findById(String counterId);

}
