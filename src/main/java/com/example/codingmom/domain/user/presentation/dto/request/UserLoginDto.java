package com.example.codingmom.domain.user.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class UserLoginDto {
    @NotNull(message = "아이디를 입력해주세요.")
    String username;
    @NotNull(message = "비밀번호를 입력해주세요.")
    String password;
}
