package com.example.demo.service.interf;

import com.example.demo.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsServiceInter {

    UserDetails loadUserByUsername(String username);

    UserDto findById(String id);

    String  createUserByUserDto(UserDto userDto);
}
