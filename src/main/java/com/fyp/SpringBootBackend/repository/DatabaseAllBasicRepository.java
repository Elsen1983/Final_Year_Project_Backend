package com.fyp.SpringBootBackend.repository;

import com.fyp.SpringBootBackend.model.DatabaseAllBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatabaseAllBasicRepository extends JpaRepository<DatabaseAllBasic, String> {

    List<DatabaseAllBasic> findByUser(String user);
}
