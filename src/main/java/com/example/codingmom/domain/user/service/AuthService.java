package com.example.codingmom.domain.user.service;

import com.example.codingmom.domain.user.entity.User;
import com.example.codingmom.domain.user.entity.repository.UserRepository;
import com.example.codingmom.domain.user.facade.UserFacade;
import com.example.codingmom.domain.user.presentation.dto.request.CreateUserDto;
import com.example.codingmom.domain.user.presentation.dto.request.UserLoginDto;
import com.example.codingmom.domain.user.presentation.dto.response.TokenResponseDto;
import com.example.codingmom.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserFacade userFacade;

    @Transactional
    public void Join(CreateUserDto dto){
        userFacade.checkUser(dto.getUsername());
        userRepository.save(dto.toEntity(passwordEncoder.encode(dto.getPassword())));
    }

    public TokenResponseDto login(UserLoginDto login, HttpServletResponse res){
        User user = userFacade.findByUsername(login.getUsername());
        userFacade.checkPassword(user.getPassword(), passwordEncoder.encode(login.getPassword()));

        String accessToken = jwtTokenProvider.createAccessToken(user.getUsername());
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getUsername());

        return TokenResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
