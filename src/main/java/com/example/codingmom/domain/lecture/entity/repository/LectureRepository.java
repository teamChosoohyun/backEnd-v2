package com.example.codingmom.domain.lecture.entity.repository;

import com.example.codingmom.domain.lecture.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    Optional<Lecture> findByUser(Long l_id);
}
