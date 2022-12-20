package com.example.codingmom.domain.user.presentation.controller;

import com.example.codingmom.domain.user.presentation.dto.UserRequestDto;
import com.example.codingmom.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user/join")
    public void Join(@RequestBody UserRequestDto dto) {
        userService.Join(dto);
    }

    @PostMapping("/user/login")
    public Map<String, String> Login(@RequestBody Map<String, String> login){
        return userService.login(login);
    }
}
