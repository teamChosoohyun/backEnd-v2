package com.example.codingmom.domain.user.facade;

import com.example.codingmom.domain.user.entity.User;
import com.example.codingmom.domain.user.entity.repository.UserRepository;
import com.example.codingmom.domain.user.exception.PasswordMismatchException;
import com.example.codingmom.domain.user.exception.UserAlreadyExistsException;
import com.example.codingmom.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void checkUser(String username){
        userRepository.findByUsername(username).ifPresent(user -> { throw UserAlreadyExistsException.EXCEPTION;} );
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void checkPassword(String password, String encodePassword){
        if (!passwordEncoder.matches(password, encodePassword)){
            throw PasswordMismatchException.EXCEPTION;
        }
    }
}
