package com.fyp.SpringBootBackend.controller;

import com.fyp.SpringBootBackend.jwt.JwtTokenProvider;
import com.fyp.SpringBootBackend.model.User;
import com.fyp.SpringBootBackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/admin/")
public class AdminController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private SimulationService simulationService;

    @Autowired
    private EditService editService;

    @Autowired
    private PageAccessService pageAccessService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private AllDataService allDataService;



//    -----------------

    @GetMapping(path = "all")
    public ResponseEntity<?> findAllUsers(){
        System.out.println("/admin/all called");
        return ResponseEntity.ok(userService.findAllUsers());
    }

//    @GetMapping(path = "admin//listbytype")
//    public ResponseEntity<?> findAllByType(){
//        System.out.println("/admin/listbytype called");
//        return ResponseEntity.ok();
//    }

    @GetMapping(path = "listbytype", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> findAllByType(
            @RequestParam(value="type") String type,
            Principal principal){
        System.out.println("/admin/listbytype{" + type +"} called by: " + principal.getName());
//        if(username.equals(principal.getName())){

            UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
            User user = userService.findByUsername(authenticationToken.getName());
            user.setToken(jwtTokenProvider.generateToken(authenticationToken));

            switch (type) {
                case "all":
                    System.out.println("Visualization type is : " + type);
                    return new ResponseEntity<>(allDataService.findAll(), HttpStatus.OK);
                case "validation":
                    System.out.println("Visualization type is : " + type);
                    return new ResponseEntity<>(validationService.findByType(type), HttpStatus.OK);
                case "simulation":
                    System.out.println("Visualization type is : " + type);
                    return new ResponseEntity<>(simulationService.findByType(type), HttpStatus.OK);
                case "editing":
                    String editFixer = "edit";
                    System.out.println("Visualization type is : " + type);
                    return new ResponseEntity<>(editService.findByType(editFixer), HttpStatus.OK);
                case "pageaccess":
                    String pageFixer = "page";
                    System.out.println("Visualization type is : " + type);
                    return new ResponseEntity<>(pageAccessService.findByType(pageFixer), HttpStatus.OK);
                case "login":
                    System.out.println("Visualization type is : " + type);
                    return new ResponseEntity<>(loginService.findByType(type), HttpStatus.OK);
                case "report":
                    System.out.println("Visualization type is : " + type);
                    return new ResponseEntity<>(reportService.findByType(type), HttpStatus.OK);
                default:
                    System.out.println("Wrong Request with " + type);
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
//        }
//        else{
//            System.out.println("Wrong Request with " + type);
//            System.out.println("Username does NOT matches with the authentication");
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
    }

}
