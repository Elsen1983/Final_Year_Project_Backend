package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabaseValidation;

import java.util.List;

public interface ValidationService {

    List<DatabaseValidation> findByUsername(String username);

    List<DatabaseValidation> findByType(String type);

}
