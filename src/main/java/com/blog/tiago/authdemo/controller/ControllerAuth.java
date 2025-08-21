package com.blog.tiago.authdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.tiago.authdemo.domain.user.LoginDto;
import com.blog.tiago.authdemo.domain.user.LoginResponse;
import com.blog.tiago.authdemo.domain.user.User;
import com.blog.tiago.authdemo.services.AuthService;


@RestController
@RequestMapping("/auth")
public class ControllerAuth {

    private final AuthService authService;

    public ControllerAuth(AuthService authService) {
        this.authService = authService;
    }
    @Autowired
    JwtEncoder jwtEncoder;



    @PostMapping("login")
    public ResponseEntity<LoginResponse> Authenticate(@RequestBody LoginDto body) throws Exception {

       var token = authService.login(body);
       
        return ResponseEntity.status(HttpStatus.OK).body(token);
        

    }

    
    

    @PostMapping("register")
    public ResponseEntity<String> registerUser(@RequestBody User body) throws Exception{
        authService.register(body);

        return ResponseEntity.ok("User registered successfully");
        
    }
    



}
