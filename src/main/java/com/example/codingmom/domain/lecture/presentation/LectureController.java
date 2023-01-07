package com.example.codingmom.domain.lecture.presentation;

import com.example.codingmom.domain.lecture.presentation.dto.request.goWorkRequestDto;
import com.example.codingmom.domain.lecture.presentation.dto.request.leaveWorkRequestDto;
import com.example.codingmom.domain.lecture.presentation.dto.request.makeWorkRequestDto;
import com.example.codingmom.domain.lecture.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/lecture")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    @PostMapping("make_work")
    public void MakeWork(@RequestBody makeWorkRequestDto dto){lectureService.makeWork(dto);}

    @PutMapping("/go_work")
    public void GoWork(@RequestBody goWorkRequestDto dto){
        lectureService.goWork(dto);
    }

    @PutMapping("/leave_work")
    public void LeaveWork(@RequestBody leaveWorkRequestDto dto){
        lectureService.leaveWork(dto);
    }

}
