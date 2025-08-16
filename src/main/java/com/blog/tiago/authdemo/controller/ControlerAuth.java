package com.blog.tiago.authdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.tiago.authdemo.domain.user.UserSignup;
import com.blog.tiago.authdemo.services.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/public/auth")
public class ControlerAuth {

    @Autowired
    private UserService userService;


    @RequestMapping("/signin")
    public ResponseEntity<Void> login(@Valid @RequestBody UserSignup userSignup) throws Exception {
        userService.signup(userSignup);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

   /*  @RequestMapping("/signup")
    public ResponseEntity<Void> signup() {
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/logout")
    public ResponseEntity<Void> logout() {
        return ResponseEntity.ok().build();
    }*/


}
