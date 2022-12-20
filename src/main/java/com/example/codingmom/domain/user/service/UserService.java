package com.example.codingmom.domain.user.service;

import com.example.codingmom.domain.user.entity.User;
import com.example.codingmom.domain.user.entity.repository.UserRepository;
import com.example.codingmom.domain.user.presentation.dto.UserDto;
import com.example.codingmom.domain.user.presentation.dto.UserRequestDto;
import com.example.codingmom.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void Join(UserRequestDto dto){
        User user = dto.toEntity(passwordEncoder);
        userRepository.save(user);
    }

    public Map<String, String> login(Map<String, String> login){
        Optional<User> user = userRepository.findByUsername(login.get("username"));
        return user.map(value -> jwtTokenProvider.createAccessToken(value.getUsername(), value.getRoles()))
                .orElse(null);
    }
}
