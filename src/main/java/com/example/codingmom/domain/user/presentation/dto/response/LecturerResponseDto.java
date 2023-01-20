package com.example.codingmom.domain.user.presentation.dto.response;

import com.example.codingmom.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LecturerResponseDto {

    private Long id;
    private String name;
    private String k_img_url;
    private String kakaoid;
    private String category;

    @Builder
    public LecturerResponseDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.k_img_url = user.getK_img_url();
        this.kakaoid = user.getKakaoid();
        this.category = user.getCategory();
    }
}
