package com.virasatsetu.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "heritage_quiz_records")
public class QuizRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String challengeTitle;

    @Column(nullable = false)
    private String category;

    private Integer scorePercent;
    private Integer xpAwarded;

    private LocalDateTime completedAt = LocalDateTime.now();

    public QuizRecord() {}

    public QuizRecord(String userEmail, String challengeTitle, String category, Integer scorePercent, Integer xpAwarded) {
        this.userEmail = userEmail;
        this.challengeTitle = challengeTitle;
        this.category = category;
        this.scorePercent = scorePercent;
        this.xpAwarded = xpAwarded;
    }

    public Long getId() { return id; }
    public String getUserEmail() { return userEmail; }
    public String getChallengeTitle() { return challengeTitle; }
    public String getCategory() { return category; }
    public Integer getScorePercent() { return scorePercent; }
    public Integer getXpAwarded() { return xpAwarded; }
    public LocalDateTime getCompletedAt() { return completedAt; }
}