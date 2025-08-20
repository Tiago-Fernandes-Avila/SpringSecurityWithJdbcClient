package com.blog.tiago.authdemo.domain.user;

import java.time.Instant;

public record LoginResponse (
    String token,
    Long expires
){

    public LoginResponse(String token2, Instant plusMillis) {
        this(token2, plusMillis.toEpochMilli());
    }
    
}
