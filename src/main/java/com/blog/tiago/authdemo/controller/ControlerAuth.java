package com.blog.tiago.authdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.tiago.authdemo.domain.user.LoginDto;
import com.blog.tiago.authdemo.domain.user.LoginResponse;
import com.blog.tiago.authdemo.domain.user.User;
import com.blog.tiago.authdemo.services.AuthService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/auth")
public class ControlerAuth {

    private final AuthService authService;

    public ControlerAuth(AuthService authService) {
        this.authService = authService;
    }
    @Autowired
    JwtEncoder jwtEncoder;



    @PostMapping("/login")
    public ResponseEntity<LoginResponse> Authenticate(@RequestBody LoginDto body) throws Exception {

        authService.login(body);
        return ResponseEntity.ok().build();

    }

    
    

    @PostMapping("register")
    public ResponseEntity<String> registerUser(@RequestBody User body) throws Exception{
        authService.signup(body);

        return ResponseEntity.status(HttpStatus.CREATED).build();
        
    }
    



}
