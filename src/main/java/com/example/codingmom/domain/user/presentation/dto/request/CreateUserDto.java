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
    public User toEntity(String k_id){
        return User.builder()
                .name(name)
                .k_img_url(k_img_url)
                .kakaoid(k_id)
                .type(type)
                .category(category)
                .role(Role.USER)
                .build();
    }
}
