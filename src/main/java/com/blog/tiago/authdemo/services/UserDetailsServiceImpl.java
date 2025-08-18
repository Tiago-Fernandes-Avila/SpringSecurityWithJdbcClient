package com.blog.tiago.authdemo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.tiago.authdemo.domain.user.User;
import com.blog.tiago.authdemo.domain.user.UserAuthenticated;
import com.blog.tiago.authdemo.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        UserDetails userDetails = new UserAuthenticated(user);
        return userDetails;


    }

    

    


}