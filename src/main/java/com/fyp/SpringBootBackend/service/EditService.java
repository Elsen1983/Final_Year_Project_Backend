package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabaseEditing;

import java.util.List;

public interface EditService {
    List<DatabaseEditing> findByUsername(String username);
}
