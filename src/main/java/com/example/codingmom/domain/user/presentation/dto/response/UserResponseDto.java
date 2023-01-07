package com.example.codingmom.domain.user.presentation.dto.response;

import com.example.codingmom.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class UserResponseDto {
    String name;
    Long type;
    String category;
    String k_img_url;
    String kakaoid;

    @Builder
    public UserResponseDto(User user){
        this.name = user.getName();
        this.category = user.getCategory();
        this.type = user.getType();
        this.k_img_url = user.getK_img_url();
        this.kakaoid = getKakaoid();
    }
}
