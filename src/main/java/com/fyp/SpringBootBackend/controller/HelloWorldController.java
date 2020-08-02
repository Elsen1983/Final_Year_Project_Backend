package com.fyp.SpringBootBackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @RequestMapping({ "/hello" })

    public String firstPage() {

        return "Hello World";

    }

}