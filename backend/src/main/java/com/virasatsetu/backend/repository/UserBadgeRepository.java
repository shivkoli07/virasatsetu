package com.virasatsetu.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virasatsetu.backend.entity.UserBadge;

@Repository
public interface UserBadgeRepository extends JpaRepository<UserBadge, Long> {
    List<UserBadge> findByUserEmail(String userEmail);
    boolean existsByUserEmailAndBadgeTitle(String userEmail, String badgeTitle);
}