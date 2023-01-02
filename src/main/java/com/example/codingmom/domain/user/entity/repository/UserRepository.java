package com.example.codingmom.domain.user.entity.repository;


import com.example.codingmom.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByKakaoid(String Kakaoid);
}
