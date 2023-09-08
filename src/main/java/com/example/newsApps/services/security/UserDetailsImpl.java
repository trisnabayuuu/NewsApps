package com.example.newsApps.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.newsApps.models.User;
import com.example.newsApps.repositories.UserRepository;

@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        if (!userRepository.existsByUsername(username)){
            throw new UsernameNotFoundException(username + " tidak ditemukan");
        }

        User user = userRepository.findByUsername(username);
        
        return com.example.newsApps.services.security.UserDetailsService.buid(user);
    }
    
}
