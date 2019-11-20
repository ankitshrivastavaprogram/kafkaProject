package com.ankit.admin.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ankit.admin.model.TokenType;
public interface TokenTypeRepository extends JpaRepository<TokenType,Long>{

	Optional<TokenType> findById(Long tokenTypeId);
}


