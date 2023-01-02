package com.example.codingmom.domain.lecture.facade;

import com.example.codingmom.domain.lecture.entity.Lecture;
import com.example.codingmom.domain.lecture.entity.repository.LectureRepository;
import com.example.codingmom.domain.lecture.exception.LectureNotFoundException;
import com.example.codingmom.domain.lecture.exception.LecturerNotFoundException;
import com.example.codingmom.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LectureFacade {
    private final LectureRepository lectureRepository;

    public Lecture findLecture(Long l_id){
        return lectureRepository.findById(l_id)
                .orElseThrow(() -> LectureNotFoundException.EXCEPTION);
    }

    public User findLecturer(Long id){
        return lectureRepository.findByUser(id)
                .orElseThrow(() -> LecturerNotFoundException.EXCEPTION);
    }
}
