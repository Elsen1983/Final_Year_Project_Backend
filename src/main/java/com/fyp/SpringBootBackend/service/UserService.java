package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.*;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User findByUsername(String userLoginName);

    List<User> findAllUsers();

    List<DatabaseAll> findByUser(String user);

    List<DatabaseAllBasic> findByUserBasic(String user);

}
