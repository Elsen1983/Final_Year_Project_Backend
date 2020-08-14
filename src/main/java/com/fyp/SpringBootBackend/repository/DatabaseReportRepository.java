package com.fyp.SpringBootBackend.repository;

import com.fyp.SpringBootBackend.model.DatabaseReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseReportRepository extends JpaRepository<DatabaseReport, String> {

    List<DatabaseReport> findByUsername(String username);

    List<DatabaseReport> findByType(String type);
}
