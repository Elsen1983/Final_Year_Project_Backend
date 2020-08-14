package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabaseAll;

import java.util.List;

public interface AllDataService {

    List<DatabaseAll> findAll();
}
