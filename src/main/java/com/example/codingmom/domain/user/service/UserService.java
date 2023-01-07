package com.example.codingmom.domain.user.service;

import com.example.codingmom.domain.user.facade.UserFacade;
import com.example.codingmom.domain.user.presentation.dto.response.UserResponseDto;
import com.example.codingmom.global.security.jwt.JwtTokenProvider;
import com.example.codingmom.global.util.CookieUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;
    private final CookieUtil cookieUtil;

//    public UserResponseDto getUserInfo(HttpServletRequest req) {
//        Cookie token = cookieUtil.getCookie(req, "accessToken");
//        Claims parseJwtToken = jwtTokenProvider.parseJwtToken(token.getValue());
//        userFacade.checkUser(parseJwtToken.getSubject());
//        return new UserResponseDto(userFacade.findByKakaoid(parseJwtToken.getSubject()));
//    }

    public UserResponseDto getUserInfo(String token) {
        Claims parseJwtToken = jwtTokenProvider.parseJwtToken(token);
        return new UserResponseDto(userFacade.findByKakaoid(parseJwtToken.getSubject()));
    }
}
