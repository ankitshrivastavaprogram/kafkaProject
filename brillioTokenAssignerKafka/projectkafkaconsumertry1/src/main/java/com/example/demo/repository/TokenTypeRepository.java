package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TokenType;



public interface TokenTypeRepository extends JpaRepository<TokenType,Long>{

	Optional<TokenType> findById(Long tokenTypeId);
}


