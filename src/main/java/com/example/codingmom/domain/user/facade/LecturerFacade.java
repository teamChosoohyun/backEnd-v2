package com.example.codingmom.domain.user.facade;

import com.example.codingmom.domain.lecture.exception.LecturerNotFoundException;
import com.example.codingmom.domain.user.entity.User;
import com.example.codingmom.domain.user.entity.repository.UserRepository;
import com.example.codingmom.domain.user.exception.NotLecturerException;
import com.example.codingmom.domain.user.presentation.dto.response.LecturerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LecturerFacade {
    private final UserRepository userRepository;

    public LecturerResponseDto getLecturer(Long id, Long type){
        if(type!=1) throw new NotLecturerException();
        User user = userRepository.findByIdAndType(id, type)
                .orElseThrow(() -> LecturerNotFoundException.EXCEPTION);
        LecturerResponseDto lecturerResponseDto = new LecturerResponseDto();
        lecturerResponseDto.setId(user.getId());
        lecturerResponseDto.setName(user.getName());
        lecturerResponseDto.setK_img_url(user.getK_img_url());
        lecturerResponseDto.setCategory(user.getCategory());
        return lecturerResponseDto;
    }

}
