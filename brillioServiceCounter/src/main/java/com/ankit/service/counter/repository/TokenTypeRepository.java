package com.ankit.service.counter.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ankit.service.counter.model.TokenType;


public interface TokenTypeRepository extends JpaRepository<TokenType,Long>{

	Optional<TokenType> findById(Long tokenTypeId);
}


