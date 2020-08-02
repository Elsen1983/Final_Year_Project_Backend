package com.fyp.SpringBootBackend.repository;

import com.fyp.SpringBootBackend.model.DatabaseValidation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseValidationRepository extends JpaRepository<DatabaseValidation, String> {

    //@Query(value="", nativeQuery=true)
    List<DatabaseValidation> findByUserAndType(String user, String type);
}
