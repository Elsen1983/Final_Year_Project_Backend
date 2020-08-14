package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabaseAll;
import com.fyp.SpringBootBackend.repository.DatabaseAllRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AllDataServiceImplementation implements AllDataService{

    @Autowired
    private DatabaseAllRepository databaseAllRepository;

    @Override
    public List<DatabaseAll> findAll() {

        return databaseAllRepository.findAll();
    }

}
