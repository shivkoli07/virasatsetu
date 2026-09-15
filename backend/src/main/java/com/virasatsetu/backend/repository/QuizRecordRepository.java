package com.virasatsetu.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virasatsetu.backend.entity.QuizRecord;

@Repository
public interface QuizRecordRepository extends JpaRepository<QuizRecord, Long> {
    List<QuizRecord> findByUserEmailOrderByCompletedAtDesc(String userEmail);
}