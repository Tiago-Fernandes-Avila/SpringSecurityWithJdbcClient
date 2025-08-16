package com.blog.tiago.authdemo.services;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.tiago.authdemo.domain.user.User;
import com.blog.tiago.authdemo.domain.user.UserSignup;
import com.blog.tiago.authdemo.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }    

    @Transactional
    public void signup (UserSignup userSignup) throws Exception{
        String email = userSignup.email();
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new Exception("User with email already exists");
        }
        String encodedString = passwordEncoder.encode(userSignup.password());
        User user = new User(userSignup.username(), userSignup.email(), encodedString);
        userRepository.add(user);
    }
    

}
