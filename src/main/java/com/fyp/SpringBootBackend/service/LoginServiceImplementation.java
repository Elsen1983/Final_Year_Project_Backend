package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabaseLogin;
import com.fyp.SpringBootBackend.repository.DatabaseLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LoginServiceImplementation implements LoginService{
    @Autowired
    private DatabaseLoginRepository databaseLoginRepository;

    @Override
    public List<DatabaseLogin> findByUsername(String username) {
        return databaseLoginRepository.findByUsername(username);
    }

    @Override
    public List<DatabaseLogin> findByType(String type) {
        return databaseLoginRepository.findByType(type);
    }
}