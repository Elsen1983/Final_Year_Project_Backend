package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabaseReport;
import com.fyp.SpringBootBackend.repository.DatabaseReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReportServiceImplementation implements ReportService{
    @Autowired
    private DatabaseReportRepository databaseReportRepository;

    @Override
    public List<DatabaseReport> findByUsername(String username) {
        return databaseReportRepository.findByUsername(username);
    }

    @Override
    public List<DatabaseReport> findByType(String type) {
        return databaseReportRepository.findByType(type);
    }
}
