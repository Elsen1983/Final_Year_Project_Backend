package com.fyp.SpringBootBackend.repository;

import com.fyp.SpringBootBackend.model.DatabaseSimulation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseSimulationRepository extends JpaRepository<DatabaseSimulation, String> {

   List<DatabaseSimulation> findByUsername(String username);
}
