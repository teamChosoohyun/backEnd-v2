package com.example.codingmom.domain.user.service;

import com.example.codingmom.domain.user.facade.UserFacade;
import com.example.codingmom.domain.user.presentation.dto.response.UserResponseDto;
import com.example.codingmom.global.security.jwt.JwtTokenProvider;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;

    public UserResponseDto getUserInfo(String token) {
        Claims parseJwtToken = jwtTokenProvider.parseJwtToken(token);
        return new UserResponseDto(userFacade.findByKakaoid(parseJwtToken.getSubject()));
    }
}
