package com.example.codingmom.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Setter
public class LecturerResponseDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String k_img_url;
    @NotNull
    private String category;

}
