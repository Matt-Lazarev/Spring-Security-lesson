package com.lazarev.springsecuritylesson.dto;

public record UserDto(String username, String rawPassword, String role) { }
