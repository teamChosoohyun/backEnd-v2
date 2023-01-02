package com.example.codingmom.domain.user.facade;

import com.example.codingmom.domain.user.entity.User;
import com.example.codingmom.domain.user.entity.repository.UserRepository;
import com.example.codingmom.domain.user.exception.KakaoidMismatchException;
import com.example.codingmom.domain.user.exception.UserAlreadyExistsException;
import com.example.codingmom.domain.user.exception.UserNotFoundException;
import com.example.codingmom.global.security.jwt.JwtTokenProvider;
import com.example.codingmom.global.util.CookieUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final CookieUtil createCookie;

    public void checkUser(String kakaoid){
        userRepository.findByKakaoid(kakaoid).ifPresent(user -> { throw UserAlreadyExistsException.EXCEPTION;} );
    }

    public User findByKakaoid(String k_id){
        return userRepository.findByKakaoid(k_id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void checkKakaoid(String password, String encodePassword){
        if (!passwordEncoder.matches(password, encodePassword)){
            throw KakaoidMismatchException.EXCEPTION;
        }
    }

    public void login(User user, HttpServletResponse response){
        String accessToken = jwtTokenProvider.createAccessToken(user.getKakaoid());
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getKakaoid());

        response.addCookie(createCookie.createCookie("accessToken", accessToken));
        response.addCookie(createCookie.createCookie("refreshToken", refreshToken));
    }
}
