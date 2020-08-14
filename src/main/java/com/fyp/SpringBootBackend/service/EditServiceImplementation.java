package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabaseEditing;
import com.fyp.SpringBootBackend.repository.DatabaseEditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EditServiceImplementation implements EditService{
    @Autowired
    private DatabaseEditRepository databaseEditRepository;

    @Override
    public List<DatabaseEditing> findByUsername(String username) {
        return databaseEditRepository.findByUsername(username);
    }

    @Override
    public List<DatabaseEditing> findByType(String type) {
        return databaseEditRepository.findByType(type);
    }
}
