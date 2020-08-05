package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabaseReport;

import java.util.List;

public interface ReportService {
    List<DatabaseReport> findByUsername(String username);
}
