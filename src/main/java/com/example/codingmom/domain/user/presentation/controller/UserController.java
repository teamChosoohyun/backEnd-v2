package com.example.codingmom.domain.user.presentation.controller;


import com.example.codingmom.domain.user.presentation.dto.response.UserResponseDto;
import com.example.codingmom.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

//    @GetMapping("/info")
//    public UserResponseDto getUserInfo(HttpServletRequest req){
//        return userService.getUserInfo(req);
//    }

    @GetMapping("/info")
    public UserResponseDto getUserInfo(@CookieValue("accessToken") String token){
        return userService.getUserInfo(token);
    }
}
