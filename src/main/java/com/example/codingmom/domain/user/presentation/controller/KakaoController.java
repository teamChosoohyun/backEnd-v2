package com.example.codingmom.domain.user.presentation.controller;

import com.example.codingmom.domain.user.presentation.dto.response.TokenResponseDto;
import com.example.codingmom.domain.user.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kakao")
public class KakaoController {

    private final KakaoService kakaoService;

    @GetMapping("/getKakaoUserInfo")
    public Map<String, Object> getKakaoUserInfo(@RequestParam(value = "code") String code) {
        String access_code = kakaoService.getAccessToken(code);
        return kakaoService.getUserInfo(access_code);
    }

    @GetMapping("/kakaoLogin")
    public boolean KakaoLogin(@Param(value = "k_id") String k_id, HttpServletResponse response) {
        return kakaoService.KakaoLogin(k_id, response);
    }
}
    