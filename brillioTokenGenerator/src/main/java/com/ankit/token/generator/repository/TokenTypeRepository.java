package com.ankit.token.generator.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ankit.token.generator.model.TokenType;

public interface TokenTypeRepository extends JpaRepository<TokenType, Long> {

	Optional<TokenType> findById(Long tokenTypeId);
}
