package com.example.codingmom.domain.user.service;

import com.example.codingmom.domain.user.facade.LecturerFacade;
import com.example.codingmom.domain.user.presentation.dto.response.LecturerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LecturerService {
    private final LecturerFacade lecturerFacade;

    public LecturerResponseDto getLecturerInfo(Long id, Long type){
        return lecturerFacade.getLecturer(id,type);
    }
}
