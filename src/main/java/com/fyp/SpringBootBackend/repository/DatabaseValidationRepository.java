package com.fyp.SpringBootBackend.repository;

import com.fyp.SpringBootBackend.model.DatabaseValidation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseValidationRepository extends JpaRepository<DatabaseValidation, String> {

    List<DatabaseValidation> findByUsername(String username);
}
