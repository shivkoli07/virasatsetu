package com.virasatsetu.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virasatsetu.backend.entity.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
    List<Story> findByUserEmailOrderByCreatedAtDesc(String userEmail);
}