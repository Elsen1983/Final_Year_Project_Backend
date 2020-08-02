package com.fyp.SpringBootBackend.controller;

import com.fyp.SpringBootBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/admin/all")
    public ResponseEntity<?> findAllUsers(){
        System.out.println("/admin/all called");
        return ResponseEntity.ok(userService.findAllUsers());
    }
}
