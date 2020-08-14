package com.fyp.SpringBootBackend.repository;

import com.fyp.SpringBootBackend.model.DatabasePageAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabasePageAccessRepository extends JpaRepository<DatabasePageAccess, String> {

    List<DatabasePageAccess> findByUsername(String username);

    List<DatabasePageAccess> findByType(String type);
}
