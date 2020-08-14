package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabasePageAccess;

import java.util.List;

public interface PageAccessService {
    List<DatabasePageAccess> findByUsername(String username);

    List<DatabasePageAccess> findByType(String type);
}
