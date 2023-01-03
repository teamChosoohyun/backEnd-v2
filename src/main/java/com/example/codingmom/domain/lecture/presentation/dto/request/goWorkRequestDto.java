package com.example.codingmom.domain.lecture.presentation.dto.request;

import com.example.codingmom.domain.lecture.entity.Lecture;
import com.example.codingmom.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Getter
@Setter
public class goWorkRequestDto {
    @NotNull
    private Long l_id;

    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime goWork;

    @Builder
    public Lecture toEntity(Lecture lecture){
        return Lecture.builder()
                .id(lecture.getId())
                .user(lecture.getUser())
                .category(lecture.getCategory())
                .goWork(goWork)
                .leaveWork(null)
                .build();
    }
}
