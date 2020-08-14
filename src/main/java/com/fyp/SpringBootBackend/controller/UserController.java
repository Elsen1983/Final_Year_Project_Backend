package com.fyp.SpringBootBackend.controller;

import com.fyp.SpringBootBackend.jwt.JwtTokenProvider;
import com.fyp.SpringBootBackend.model.Role;
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
@RequestMapping("/api/user/")
public class UserController {

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

    @PostMapping("registration")
    public ResponseEntity<?> register(@RequestBody User user){
        if(userService.findByUsername(user.getUsername()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping(path = "login")
    public ResponseEntity<?> login(Principal principal){
        if(principal == null){
            return ResponseEntity.ok(principal);
        }
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
        User user = userService.findByUsername(authenticationToken.getName());
        user.setToken(jwtTokenProvider.generateToken(authenticationToken));
        //System.out.println("/api/user/login called with user:" + principal.getName());
        return new ResponseEntity<>(userService.findByUsername(principal.getName()), HttpStatus.OK);
    }

    //sending back all the data where the user is the same as the user who called the endpoint
    @GetMapping(path="userdata")
    public ResponseEntity<?> userData(Principal principal){
            System.out.println("/user/userdata called with: " + principal.toString());
            UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
            User user = userService.findByUsername(authenticationToken.getName());
            user.setToken(jwtTokenProvider.generateToken(authenticationToken));
            System.out.println(principal.getName());
            return new ResponseEntity<>(userService.findByUser(principal.getName()), HttpStatus.OK);

    }

    @GetMapping(path = "basicdata", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> basicUserData(
            @RequestParam (value="username")String username,
            Principal principal){
        System.out.println("/user/basicuserdata" + username+ " called with: " + principal.getName());
        if(username.equals(principal.getName())){
            System.out.println("Username matches with the authentication");
            UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
            User user = userService.findByUsername(authenticationToken.getName());
            user.setToken(jwtTokenProvider.generateToken(authenticationToken));
            return new ResponseEntity<>(userService.findByUserBasic(principal.getName()), HttpStatus.OK);
        }
        else{
            System.out.println("Username does NOT matches with the authentication");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping(path = "visualization", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> userDataForVisualization(
            @RequestParam(value="username")String username,
            @RequestParam(value="type") String type,
            Principal principal){
        if(username.equals(principal.getName())){

            UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
            User user = userService.findByUsername(authenticationToken.getName());
            user.setToken(jwtTokenProvider.generateToken(authenticationToken));

            switch (type) {
                case "validation":
                    System.out.println("Visualization type is : " + type);
                    return new ResponseEntity<>(validationService.findByUsername(principal.getName()), HttpStatus.OK);
                case "simulation":
                    System.out.println("Visualization type is : " + type);
                    return new ResponseEntity<>(simulationService.findByUsername(principal.getName()), HttpStatus.OK);
                case "edit":
                    System.out.println("Visualization type is : " + type);
                    return new ResponseEntity<>(editService.findByUsername(principal.getName()), HttpStatus.OK);
                case "page":
                    System.out.println("Visualization type is : " + type);
                    return new ResponseEntity<>(pageAccessService.findByUsername(principal.getName()), HttpStatus.OK);
                case "login":
                    System.out.println("Visualization type is : " + type);
                    return new ResponseEntity<>(loginService.findByUsername(principal.getName()), HttpStatus.OK);
                case "report":
                    System.out.println("Visualization type is : " + type);
                    return new ResponseEntity<>(reportService.findByUsername(principal.getName()), HttpStatus.OK);
                default:
                    System.out.println("Wrong Request with " + type);
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        else{
            System.out.println("Wrong Request with " + type);
            System.out.println("Username does NOT matches with the authentication");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
