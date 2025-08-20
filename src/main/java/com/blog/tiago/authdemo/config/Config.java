package com.blog.tiago.authdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.blog.tiago.authdemo.domain.user.User;

import com.blog.tiago.authdemo.repository.UserRepository;
import com.blog.tiago.authdemo.services.AuthService;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private AuthService service;
  

    @Override
    public void run(String... args) throws Exception {
        
        service.signup(new User("username", "email", "password"));
        
    }


}
