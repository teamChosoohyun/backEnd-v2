package com.example.codingmom.domain.user.presentation.dto;

import com.example.codingmom.domain.user.entity.Role;
import com.example.codingmom.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserRequestDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private Long type;
    private String category;
    @NotEmpty
    private String kakaoid;
    @NotEmpty
    private String k_img_url;
    @NotEmpty
    private String name;
    @Builder
    public User toEntity(PasswordEncoder passwordEncoder){
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .name(name)
                .k_img_url(k_img_url)
                .kakaoid(kakaoid)
                .type(type)
                .category(category)
                .role(Role.USER)
                .build();
    }
}
