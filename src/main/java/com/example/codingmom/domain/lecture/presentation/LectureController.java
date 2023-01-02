package com.example.codingmom.domain.lecture.presentation;

import com.example.codingmom.domain.lecture.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lecture")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

//    @PostMapping("/go_work")
//    public void GoWork(@RequestBody Long l_id, String category){
//        lectureService.goWork(l_id, category);
//    }
}
