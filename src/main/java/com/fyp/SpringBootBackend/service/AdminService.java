package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabaseAll;

import java.util.List;

public interface AdminService {

    List<DatabaseAll> findAllByType();
}
