package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabaseSimulation;

import java.util.List;

public interface SimulationService {
    List<DatabaseSimulation> findByUsername(String username);

    List<DatabaseSimulation> findByType(String type);
}
