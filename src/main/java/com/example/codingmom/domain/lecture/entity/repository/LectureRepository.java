package com.example.codingmom.domain.lecture.entity.repository;

import com.example.codingmom.domain.lecture.entity.Lecture;
import com.example.codingmom.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

     Optional<User> findByUser(Long l_id);
}
