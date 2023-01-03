package com.example.codingmom.domain.user.facade;

import com.example.codingmom.domain.user.entity.User;
import com.example.codingmom.domain.user.entity.repository.UserRepository;
import com.example.codingmom.domain.user.exception.KakaoidMismatchException;
import com.example.codingmom.domain.user.exception.UserAlreadyExistsException;
import com.example.codingmom.domain.user.exception.UserNotFoundException;
import com.example.codingmom.global.security.jwt.JwtTokenProvider;
import com.example.codingmom.global.util.CookieUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final CookieUtil createCookie;

    public void checkUser(String kakaoid){
        userRepository.findByKakaoid(kakaoid).ifPresent(user -> { throw UserAlreadyExistsException.EXCEPTION;} );
    }

    public User findByKakaoid(String k_id){
        return userRepository.findByKakaoid(k_id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void checkKakaoid(String kakaoid, String getKakaoid){
        if (!kakaoid.equals(getKakaoid)){
            throw KakaoidMismatchException.EXCEPTION;
        }
    }

    public void login(User user, HttpServletResponse response){
        String accessToken = jwtTokenProvider.createAccessToken(user.getKakaoid());
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getKakaoid());

        response.addHeader(HttpHeaders.SET_COOKIE,
                createCookie.createCookie("accessToken", accessToken, 30 * 60 * 1000L).toString());
        response.addHeader(HttpHeaders.SET_COOKIE,
                createCookie.createCookie("refreshToken", refreshToken, 1000L * 60 * 60 * 24 * 14).toString());
    }
}
