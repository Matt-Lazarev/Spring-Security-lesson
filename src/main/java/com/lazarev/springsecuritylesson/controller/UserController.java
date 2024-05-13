package com.lazarev.springsecuritylesson.controller;

import com.lazarev.springsecuritylesson.dto.UserDto;
import com.lazarev.springsecuritylesson.entity.Role;
import com.lazarev.springsecuritylesson.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lazarev.springsecuritylesson.entity.ApplicationUser;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserRepository applicationUserRepository;

    @PostMapping("/register")
    public void createUser(@RequestBody UserDto userDto) {
        Role role = new Role();
        role.setName(userDto.role().toUpperCase());

        ApplicationUser user = new ApplicationUser();
        user.setUsername(userDto.username());
        user.setRoles(Set.of(role));
        user.setPassword(passwordEncoder.encode(userDto.rawPassword()));
        applicationUserRepository.save(user);
    }
}
