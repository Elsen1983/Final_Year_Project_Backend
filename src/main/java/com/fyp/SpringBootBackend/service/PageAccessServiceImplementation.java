package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabasePageAccess;
import com.fyp.SpringBootBackend.repository.DatabasePageAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PageAccessServiceImplementation implements PageAccessService{
    @Autowired
    private DatabasePageAccessRepository databasePageAccessRepository;

    @Override
    public List<DatabasePageAccess> findByUsername(String username) {
        return databasePageAccessRepository.findByUsername(username);
    }
}
