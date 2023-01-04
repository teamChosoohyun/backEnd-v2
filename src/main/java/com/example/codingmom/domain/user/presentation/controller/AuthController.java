package com.example.codingmom.domain.user.presentation.controller;

import com.example.codingmom.domain.user.presentation.dto.request.CreateUserDto;
import com.example.codingmom.domain.user.presentation.dto.response.TokenResponseDto;
import com.example.codingmom.domain.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/join")
    public void Join(@RequestBody CreateUserDto dto, HttpServletResponse response) {
        authService.Join(dto, response);
    }
}
