package com.example.codingmom.domain.user.presentation.controller;

import com.example.codingmom.domain.user.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kakao")
public class KakaoController {

    private final KakaoService kakaoService;

    @GetMapping("/getKakaoUserInfo")
    public Map<String, Object> getKakaoUserInfo(@RequestParam(value = "code") String code) throws Exception {
        String access_code = kakaoService.getAccessToken(code);
        return kakaoService.getUserInfo(access_code);
    }

    @PostMapping("/kakaoLogin")
    public Map<String, String> KakaoLogin(@Param(value = "k_id") String k_id) throws Exception {
        return kakaoService.KakaoLogin(k_id);
    }
}
