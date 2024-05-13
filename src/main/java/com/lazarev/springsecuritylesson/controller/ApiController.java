package com.lazarev.springsecuritylesson.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api/hello")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public String getHello() {
        return "Hello GET!";
    }

    @PostMapping("/api/hello")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String postHello() {
        return "Hello POST!";
    }
}
