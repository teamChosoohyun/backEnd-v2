package com.example.codingmom.domain.user.presentation.dto.response;

import com.example.codingmom.domain.user.entity.Role;
import com.example.codingmom.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class UserDto {
    String name;
    Long type;
    String category;
    String kakaoid;
    String k_img_url;
    List<String> roles;
    String username;
    String password;

    @Builder
    public UserDto(User user){
        this.name = user.getName();
        this.category = user.getCategory();
        this.type = user.getType();
        this.kakaoid = user.getKakaoid();
        this.k_img_url = user.getK_img_url();
        this.roles = user.getRoles();
        this.username = user.getUsername();
    }
}
