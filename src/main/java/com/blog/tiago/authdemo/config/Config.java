package com.blog.tiago.authdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.blog.tiago.authdemo.domain.user.UserSignup;
import com.blog.tiago.authdemo.repository.UserRepository;
import com.blog.tiago.authdemo.services.UserService;

@Configuration
public class Config implements CommandLineRunner {

    private final UserService userService;

    public Config(UserService userService){
        this.userService = userService;
    }
  

    @Override
    public void run(String... args) throws Exception {
        
        
    }


}
