package com.fyp.SpringBootBackend.repository;

import com.fyp.SpringBootBackend.model.DatabaseLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseLoginRepository extends JpaRepository<DatabaseLogin, String> {
    List<DatabaseLogin> findByUsername(String username);

    List<DatabaseLogin> findByType(String type);
}
