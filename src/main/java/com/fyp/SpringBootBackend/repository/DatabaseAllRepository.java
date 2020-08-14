package com.fyp.SpringBootBackend.repository;


import com.fyp.SpringBootBackend.model.DatabaseAll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatabaseAllRepository extends JpaRepository<DatabaseAll, String> {

    //List<DatabaseAll> findByCompanyName(String company_name);

    List<DatabaseAll> findByUser(String user);

    List<DatabaseAll> findAll();
}
