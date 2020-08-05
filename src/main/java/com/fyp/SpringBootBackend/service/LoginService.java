package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabaseLogin;

import java.util.List;

public interface LoginService {
    List<DatabaseLogin> findByUsername(String username);
}
