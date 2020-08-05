package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabaseSimulation;
import com.fyp.SpringBootBackend.repository.DatabaseSimulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SimulationServiceImplementation implements SimulationService {

    @Autowired
    private DatabaseSimulationRepository databaseSimulationRepository;

    @Override
    public List<DatabaseSimulation> findByUsername(String username) {
        return databaseSimulationRepository.findByUsername(username);
    }
}
