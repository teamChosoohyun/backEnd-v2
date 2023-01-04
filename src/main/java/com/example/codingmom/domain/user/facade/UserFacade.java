package com.example.codingmom.domain.user.facade;

import com.example.codingmom.domain.user.entity.User;
import com.example.codingmom.domain.user.entity.repository.UserRepository;
import com.example.codingmom.domain.user.exception.KakaoidMismatchException;
import com.example.codingmom.domain.user.exception.UserAlreadyExistsException;
import com.example.codingmom.domain.user.exception.UserNotFoundException;
import com.example.codingmom.domain.user.presentation.dto.response.LecturerResponseDto;
import com.example.codingmom.global.security.jwt.JwtTokenProvider;
import com.example.codingmom.global.util.CookieUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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

    public void login(String kakaoid, HttpServletResponse response){

        User user = findByKakaoid(kakaoid);

        String accessToken = jwtTokenProvider.createAccessToken(kakaoid, user.getRoles());
        String refreshToken = jwtTokenProvider.createRefreshToken(kakaoid, user.getRoles());

        response.addHeader(HttpHeaders.SET_COOKIE,
                createCookie.createCookie("accessToken", accessToken, 30 * 60 * 1000L).toString());
        response.addHeader(HttpHeaders.SET_COOKIE,
                createCookie.createCookie("refreshToken", refreshToken, 1000L * 60 * 60 * 24 * 14).toString());
    }

    public List<LecturerResponseDto> getLecturerList(List<User> lecturerList){
        List<LecturerResponseDto> list = new ArrayList<>();

        for(User u : lecturerList){
            list.add(
                    LecturerResponseDto.builder()
                            .id(u.getId())
                            .name(u.getName())
                            .k_img_url(u.getK_img_url())
                            .category(u.getCategory())
                            .build()
            );
        }

        return list;
    }
}
