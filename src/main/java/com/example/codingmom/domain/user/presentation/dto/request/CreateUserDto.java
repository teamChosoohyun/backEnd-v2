package com.example.codingmom.domain.user.presentation.dto.request;

import com.example.codingmom.domain.user.entity.Role;
import com.example.codingmom.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateUserDto {
    @NotNull(message = "아이디를 입력해주세요.")
    private String username;

    @NotNull(message = "비밀번호를 입력해주세요.")
    private String password;
    @NotNull
    private Long type;
    private String category;
    @NotNull
    private String kakaoid;
    @NotNull
    private String k_img_url;
    @NotNull
    private String name;
    @Builder
    public User toEntity(String password){
        return User.builder()
                .username(username)
                .password(password)
                .name(name)
                .k_img_url(k_img_url)
                .kakaoid(kakaoid)
                .type(type)
                .category(category)
                .role(Role.USER)
                .build();
    }
}
