package com.lazarev.springsecuritylesson.controller;

import com.lazarev.springsecuritylesson.dto.UserDto;
import com.lazarev.springsecuritylesson.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lazarev.springsecuritylesson.entity.ApplicationUser;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserRepository applicationUserRepository;

    @GetMapping("/register")
    public void createUser(@RequestBody UserDto userDto) {
        ApplicationUser user = new ApplicationUser();
        user.setUsername(userDto.username());
        user.setRole(userDto.role());
        user.setPassword(passwordEncoder.encode(userDto.rawPassword()));
        applicationUserRepository.save(user);
    }
}
