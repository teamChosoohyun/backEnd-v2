package com.example.codingmom.domain.user.service;

import com.example.codingmom.domain.user.entity.User;
import com.example.codingmom.domain.user.entity.repository.UserRepository;
import com.example.codingmom.domain.user.facade.UserFacade;
import com.example.codingmom.domain.user.presentation.dto.request.CreateUserDto;
import com.example.codingmom.domain.user.presentation.dto.request.UserLoginDto;
import com.example.codingmom.domain.user.presentation.dto.response.TokenResponseDto;
import com.example.codingmom.domain.user.presentation.dto.response.UserResponseDto;
import com.example.codingmom.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class UserService {


//    public UserResponseDto getUserInfo(String token) {
//        jwtTokenProvider.parseJwtToken(token);
//    }
}
