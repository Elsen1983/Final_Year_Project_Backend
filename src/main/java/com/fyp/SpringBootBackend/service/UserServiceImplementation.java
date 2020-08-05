package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.*;
import com.fyp.SpringBootBackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DatabaseAllRepository databaseAllRepository;

    @Autowired
    private DatabaseAllBasicRepository databaseAllBasicRepository;

//    @Autowired
//    private DatabaseValidationRepository databaseValidationRepository;
//
//    @Autowired
//    private DatabaseSimulationRepository databaseSimulationRepository;

    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    //for admin use only
    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }


    @Override
    public User findByUsername(String username){
        System.out.println(username);
        return userRepository.findByUsername(username).orElse(null);
    }


    @Override
    public List<DatabaseAll> findByUser(String user) {
        System.out.println(user);
        return databaseAllRepository.findByUser(user);
    }

    @Override
    public List<DatabaseAllBasic> findByUserBasic(String user) {
        return databaseAllBasicRepository.findByUser(user);
    }




}
