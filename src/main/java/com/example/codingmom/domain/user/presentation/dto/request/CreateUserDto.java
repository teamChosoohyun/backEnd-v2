package com.example.codingmom.domain.user.presentation.dto.request;

import com.example.codingmom.domain.user.entity.Role;
import com.example.codingmom.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
public class CreateUserDto {
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
    public User toEntity(){
        return User.builder()
                .name(name)
                .k_img_url(k_img_url)
                .kakaoid(kakaoid)
                .type(type)
                .category(category)
                .role(Role.ROLE_USER)
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
    }
}
