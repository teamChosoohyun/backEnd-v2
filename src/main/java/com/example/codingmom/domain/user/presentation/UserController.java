package com.example.codingmom.domain.user.presentation;

import com.example.codingmom.domain.user.presentation.dto.request.CreateUserDto;
import com.example.codingmom.domain.user.presentation.dto.request.UserLoginDto;
import com.example.codingmom.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public void Join(@RequestBody @Valid CreateUserDto dto) {
        userService.Join(dto);
    }

    @PostMapping("/login")
    public String Login(@RequestBody @Valid UserLoginDto dto, HttpServletResponse res){
        return userService.login(dto, res);
    }

}
