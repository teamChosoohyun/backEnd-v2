package com.example.codingmom.domain.user.entity.repository;


import com.example.codingmom.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByKakaoid(String Kakaoid);
    Optional<User> findByUsername(String username);
}
