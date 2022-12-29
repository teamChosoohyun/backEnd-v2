package com.example.codingmom.domain.user.presentation;

import com.example.codingmom.domain.user.presentation.dto.request.CreateUserDto;
import com.example.codingmom.domain.user.presentation.dto.request.UserLoginDto;
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
    public void Join(@RequestBody @Valid CreateUserDto dto) {
        authService.Join(dto);
    }

    @PostMapping("/login")
    public TokenResponseDto Login(@RequestBody @Valid UserLoginDto dto, HttpServletResponse res){
        return authService.login(dto, res);
    }
}
