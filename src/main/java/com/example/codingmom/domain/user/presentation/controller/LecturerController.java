package com.example.codingmom.domain.user.presentation.controller;

import com.example.codingmom.domain.user.presentation.dto.response.LecturerResponseDto;
import com.example.codingmom.domain.user.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class LecturerController {
    private final LecturerService lecturerService;

    @GetMapping("/lecturer/{id}")
    public LecturerResponseDto getLecturer(@PathVariable Long id){
        return lecturerService.getLecturerInfo(id);
    }

    @GetMapping("/lecturer")
    public List<LecturerResponseDto> getLecturerList(){
        return lecturerService.getLecturerList();
    }

    @GetMapping("/lecturer/info/{category}")
    public List<LecturerResponseDto> getLecturerByCategory(@PathVariable String category){
        return lecturerService.getLecturerByCategory(category);
    }
}
