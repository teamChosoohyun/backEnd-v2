package com.example.codingmom.domain.user.presentation;

import com.example.codingmom.domain.user.presentation.dto.request.CreateUserDto;
import com.example.codingmom.domain.user.presentation.dto.request.UserLoginDto;
import com.example.codingmom.domain.user.presentation.dto.response.TokenResponseDto;
import com.example.codingmom.domain.user.presentation.dto.response.UserResponseDto;
import com.example.codingmom.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

//    @GetMapping("/info")
//    public UserResponseDto getUserInfo(@RequestHeader("Authorization") String token){
//        return userService.getUserInfo(token);
//    }
}
