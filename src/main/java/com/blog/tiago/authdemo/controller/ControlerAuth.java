package com.blog.tiago.authdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.tiago.authdemo.services.AuthService;
import com.blog.tiago.authdemo.services.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/public/auth")
public class ControlerAuth {

    private final AuthService authService;

    public ControlerAuth(AuthService authService) {
        this.authService = authService;
    }



    


    @RequestMapping("/signin")
    public ResponseEntity<String> Authenticate(Authentication authentication) throws Exception {
        var token = authService.authenticate(authentication); 
        return ResponseEntity.ok(token);
    }



}
