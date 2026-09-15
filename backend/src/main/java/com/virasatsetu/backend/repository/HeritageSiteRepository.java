package com.virasatsetu.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virasatsetu.backend.entity.HeritageSite;

@Repository
public interface HeritageSiteRepository extends JpaRepository<HeritageSite, Long> {
    List<HeritageSite> findByStateIgnoreCase(String state);
    List<HeritageSite> findByCategoryIgnoreCase(String category);
}