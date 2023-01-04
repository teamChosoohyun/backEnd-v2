package com.example.codingmom.domain.user.presentation.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;
@Getter
public class LecturerRequestDto {
    @NotNull
    private Long type;
}
