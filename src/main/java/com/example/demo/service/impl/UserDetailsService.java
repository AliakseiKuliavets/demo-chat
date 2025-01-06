package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.interf.UserDetailsServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements UserDetailsServiceInter {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDto findById(String id) {
        return userMapper.toDto(userRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new UsernameNotFoundException("user not found")));
    }

    @Override
    public String createUserByUserDto(UserDto userDto) {
        if (userDto.getUserLogin().equals(userRepository.findByUserName(userDto.getUserLogin()))) {
            return "User with this login is already exist";
        } else if (userDto.getUserName().equals(userRepository.findByUserName(userDto.getUserName()))) {
            return "User with this name is already exist";
        } else {
            User user = userMapper.toEntity(userDto);
            userRepository.save(user);
            return "User created";
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        User.UserBuilder builder = User.builder();
        builder.userName(user.getUserName());
        builder.userPassword(user.getUserPassword());
        return (UserDetails) builder.build();
    }
}
