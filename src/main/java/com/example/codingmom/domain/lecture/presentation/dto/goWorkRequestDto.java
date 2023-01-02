package com.example.codingmom.domain.lecture.presentation.dto;

import com.example.codingmom.domain.lecture.entity.Lecture;
import com.example.codingmom.domain.user.entity.User;
import lombok.Builder;

import javax.validation.constraints.NotNull;

public class goWorkRequestDto {

    @NotNull
    private User user;
    @NotNull
    private String category;

    @Builder
    public Lecture toEntity(Lecture lecture){
        return Lecture.builder()
                .id(lecture.getId())
                .user(lecture.getUser())
                .category(lecture.getCategory())
                .goWork(null)
                .leaveWork(lecture.getLeaveWork())
                .build();
    }
}
