package com.example.codingmom.domain.lecture.presentation.dto.request;

import com.example.codingmom.domain.lecture.entity.Lecture;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class leaveWorkRequestDto {

    @NotNull
    private Long l_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime leaveWork;

    @Builder
    public Lecture toEntity(Lecture lecture){
        return Lecture.builder()
                .id(lecture.getId())
                .user(lecture.getUser())
                .goWork(lecture.getGoWork())
                .leaveWork(leaveWork)
                .build();
    }
}
