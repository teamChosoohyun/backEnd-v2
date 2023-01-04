package com.example.codingmom.domain.user.presentation.controller;

import com.example.codingmom.domain.user.presentation.dto.request.LecturerRequestDto;
import com.example.codingmom.domain.user.presentation.dto.response.LecturerResponseDto;
import com.example.codingmom.domain.user.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class RecturerController {
    private final LecturerService lecturerService;

    @GetMapping("/lecturer/{id}")
    public LecturerResponseDto GetLecturer(@PathVariable("id")Long id, @RequestBody @Valid LecturerRequestDto dto){
        return lecturerService.getLecturerInfo(id,dto.getType());
    }
}
