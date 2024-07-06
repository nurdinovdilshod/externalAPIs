package com.company.controller;

import com.company.dto.UserCreateDTO;
import com.company.entity.AuthUser;
import com.company.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UsersController {
    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<AuthUser> create(@RequestBody UserCreateDTO dto) {
        return ResponseEntity.status(201).body(userService.create(dto));
    }
}
