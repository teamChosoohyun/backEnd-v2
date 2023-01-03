package com.example.codingmom.domain.lecture.service;

import com.example.codingmom.domain.lecture.entity.Lecture;
import com.example.codingmom.domain.lecture.entity.repository.LectureRepository;
import com.example.codingmom.domain.lecture.facade.LectureFacade;
import com.example.codingmom.domain.lecture.presentation.dto.request.goWorkRequestDto;
import com.example.codingmom.domain.lecture.presentation.dto.request.leaveWorkRequestDto;
import com.example.codingmom.domain.lecture.presentation.dto.request.makeWorkRequestDto;
import com.example.codingmom.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureFacade lectureFacade;
    private final LectureRepository lectureRepository;

    @Transactional
    public void goWork(goWorkRequestDto dto){
        Lecture lecture = lectureFacade.findLecture(dto.getL_id());
        lectureRepository.save(dto.toEntity(lecture));
    }
    @Transactional
    public void leaveWork(leaveWorkRequestDto dto){
        Lecture lecture = lectureFacade.findLecture(dto.getL_id());
        lectureRepository.save(dto.toEntity(lecture));
    }
    @Transactional
    public void makeWork(makeWorkRequestDto dto){
        User user = lectureFacade.findLecturer((dto.getUser()).getId());
        lectureRepository.save(dto.toEntity());

    }
}
