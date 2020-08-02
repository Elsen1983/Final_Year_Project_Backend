package com.fyp.SpringBootBackend.service;

import com.fyp.SpringBootBackend.model.DatabaseAll;
import com.fyp.SpringBootBackend.model.DatabaseAllBasic;
import com.fyp.SpringBootBackend.model.DatabaseValidation;
import com.fyp.SpringBootBackend.model.User;
import com.fyp.SpringBootBackend.repository.DatabaseAllBasicRepository;
import com.fyp.SpringBootBackend.repository.DatabaseAllRepository;
import com.fyp.SpringBootBackend.repository.DatabaseValidationRepository;
import com.fyp.SpringBootBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private DatabaseValidationRepository databaseValidationRepository;

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


//    @Override
//    public List<DatabaseAll> findByCompanyName(String company_name) {
//        return databaseAllRepository.findByCompanyName(company_name);
//    }

    @Override
    public List<DatabaseAll> findByUser(String user) {
        System.out.println(user);
        return databaseAllRepository.findByUser(user);
    }

    @Override
    public List<DatabaseAllBasic> findByUserBasic(String user) {
        return databaseAllBasicRepository.findByUser(user);
    }

    @Override
    public List<DatabaseValidation> findByUserAndType(String user, String type) {
        return databaseValidationRepository.findByUserAndType(user, type);
    }


}
