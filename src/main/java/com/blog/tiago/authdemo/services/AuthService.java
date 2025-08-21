package com.blog.tiago.authdemo.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.tiago.authdemo.domain.user.LoginDto;
import com.blog.tiago.authdemo.domain.user.LoginResponse;
import com.blog.tiago.authdemo.domain.user.User;
import com.blog.tiago.authdemo.repository.UserRepository;

@Service
public class AuthService {
    @Autowired
    private JwtEncoder jwtEncoder;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    

    public LoginResponse login(LoginDto user){

     var optnUser = userRepository.findByUserName(user.username()).orElseThrow(() -> new BadCredentialsException("User not found"));

        if (optnUser == null || !(passwordEncoder.matches(user.password() , optnUser.password() ))){
            throw new BadCredentialsException("Invalid password");
        }

        var expiresIn = 4L;
        var now = Instant.now();

        var claims = JwtClaimsSet.builder()
        .issuer("self")
        .issuedAt(now)
        .subject(user.username())
        .expiresAt(now.plusSeconds(expiresIn)).build();
        


        var token = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
       
        
        LoginResponse loginResponse = new LoginResponse(token, expiresIn);

        return loginResponse;

    }

    @Transactional
    public void register(User user) throws Exception{
        String email = user.email();
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new Exception("User with email already exists");
        }
        String encodedString = passwordEncoder.encode(user.password());
        User newuser = new User(user.username(), user.email(), encodedString);
        userRepository.add(newuser);
    }

}
