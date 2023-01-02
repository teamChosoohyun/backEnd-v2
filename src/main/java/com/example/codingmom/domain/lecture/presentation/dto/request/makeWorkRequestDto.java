package com.example.codingmom.domain.lecture.presentation.dto.request;

import com.example.codingmom.domain.lecture.entity.Lecture;
import com.example.codingmom.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
@Getter
@Setter
public class makeWorkRequestDto {
    @NotNull
    private User user;
    @NotNull
    private String category;
    @NotNull
    private Timestamp work_time;


    @Builder
    public Lecture toEntity(){
        return Lecture.builder()
                .user(user)
                .work_time(work_time)
                .category(category)
                .goWork(null)
                .leaveWork(null)
                .build();
    }
}
