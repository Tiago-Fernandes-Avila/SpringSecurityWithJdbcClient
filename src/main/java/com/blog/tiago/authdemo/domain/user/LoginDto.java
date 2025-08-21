package com.blog.tiago.authdemo.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record  LoginDto(
    String username,
    
    String password
) {
    
}
