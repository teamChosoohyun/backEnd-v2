package com.example.codingmom.domain.user.service;

import com.example.codingmom.domain.user.entity.repository.UserRepository;
import com.example.codingmom.domain.user.facade.UserFacade;
import com.example.codingmom.domain.user.presentation.dto.request.CreateUserDto;
import com.example.codingmom.domain.user.presentation.dto.response.TokenResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void Join(CreateUserDto dto, HttpServletResponse response){
        userFacade.checkUser(dto.getKakaoid());

        log.info(dto.getName());
        log.info(dto.getCategory());
        log.info(dto.getK_img_url());
        log.info(dto.getKakaoid());

        userRepository.save(dto.toEntity());
        userFacade.login(dto.getKakaoid(), response);
    }
}
