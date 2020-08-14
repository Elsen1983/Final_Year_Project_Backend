package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabaseValidation;
import com.fyp.SpringBootBackend.repository.DatabaseValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ValidationServiceImplementation implements ValidationService {

    @Autowired
    private DatabaseValidationRepository databaseValidationRepository;

    @Override
    public List<DatabaseValidation> findByUsername(String username) {
        return databaseValidationRepository.findByUsername(username);
    }

    @Override
    public List<DatabaseValidation> findByType(String type) {
        return databaseValidationRepository.findByType(type);
    }
}
