package com.example.codingmom.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TokenResponseDto {
    private String accessToken;
    private String refreshToken;

    @Builder
    public TokenResponseDto(String accessToken, String refreshToken){
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
