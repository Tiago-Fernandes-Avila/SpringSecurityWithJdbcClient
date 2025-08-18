package com.blog.tiago.authdemo.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record User( 
    @NotBlank(message = "Username is required")
    String username,
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String email,
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20, message= "Password must be at least 8 characters long")
    String password
){
}
