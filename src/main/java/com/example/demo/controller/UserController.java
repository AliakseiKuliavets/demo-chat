package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.impl.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class UserController {

    private final UserDetailsService userService;

    @GetMapping("/1/id")
    public UserDto getUserById(String id) {
        return userService.findById(id);
    }

    @PostMapping("/create")
    public String createUserByUserDto(UserDto userDto) {
        return userService.createUserByUserDto(userDto);
    }

}
