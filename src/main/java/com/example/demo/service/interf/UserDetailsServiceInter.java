package com.example.demo.service.interf;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsServiceInter {
    UserDetails loadUserByUsername(String username);
}
