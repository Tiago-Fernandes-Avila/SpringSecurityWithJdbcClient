package com.blog.tiago.authdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RestController
@RequestMapping("/private")
public class PrivateController {

    @GetMapping("/hello")
    public String getString() {
        return "Hello, Welcome!";
    }
    
    
}
