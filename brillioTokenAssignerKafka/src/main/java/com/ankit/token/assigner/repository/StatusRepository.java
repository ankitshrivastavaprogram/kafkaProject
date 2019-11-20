package com.ankit.token.assigner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankit.token.assigner.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

	Optional<Status> findByStatus(String status);

}
