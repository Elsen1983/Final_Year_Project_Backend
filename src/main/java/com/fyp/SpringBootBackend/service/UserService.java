package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.*;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User findByUsername(String userLoginName);

    List<User> findAllUsers();

    
    //List<DatabaseAll> findByCompanyName(String company_name);

    List<DatabaseAll> findByUser(String user);

    List<DatabaseAllBasic> findByUserBasic(String user);

    //List<DatabaseValidation> findByUserAndTypeValidation(String user, List<String> timestamps);

    //List<DatabaseValidation> findByUserAndType(String user, String type);

    //List<DatabaseSimulation> findByUserAndTypeSimulation(String user, String type);
}
