package com.fyp.SpringBootBackend.repository;

import com.fyp.SpringBootBackend.model.DatabaseEditing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseEditRepository extends JpaRepository<DatabaseEditing, String> {

    List<DatabaseEditing> findByUsername(String username);

}
