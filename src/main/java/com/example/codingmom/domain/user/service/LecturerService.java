package com.example.codingmom.domain.user.service;

import com.example.codingmom.domain.lecture.exception.LecturerNotFoundException;
import com.example.codingmom.domain.user.entity.User;
import com.example.codingmom.domain.user.entity.repository.UserRepository;
import com.example.codingmom.domain.user.facade.UserFacade;
import com.example.codingmom.domain.user.presentation.dto.response.LecturerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LecturerService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public LecturerResponseDto getLecturerInfo(Long id){
        User user = userRepository.findByIdAndType(id, 2)
                .orElseThrow(() -> LecturerNotFoundException.EXCEPTION);

        return LecturerResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .k_img_url(user.getK_img_url())
                .category(user.getCategory())
                .build();
    }

    public List<LecturerResponseDto> getLecturerList(){
        List<User> lecturerList = userRepository.findByType(1);
        return userFacade.getLecturerList(lecturerList);
    }

    public List<LecturerResponseDto> getLecturerByCategory(String category) {
        List<User> lecturerList = userRepository.findByTypeAndCategory(2, category);
        return userFacade.getLecturerList(lecturerList);
    }
}
