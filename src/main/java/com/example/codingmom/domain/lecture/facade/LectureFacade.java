package com.example.codingmom.domain.lecture.facade;

import com.example.codingmom.domain.lecture.entity.Lecture;
import com.example.codingmom.domain.lecture.entity.repository.LectureRepository;
import com.example.codingmom.domain.lecture.exception.LecturerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LectureFacade {
    private final LectureRepository lectureRepository;

    public Lecture findLecturer(Long l_id){
        return lectureRepository.findByUser(l_id)
                .orElseThrow(() -> LecturerNotFoundException.EXCEPTION);
    }
}
