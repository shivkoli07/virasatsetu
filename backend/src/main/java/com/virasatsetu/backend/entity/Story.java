package com.virasatsetu.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "heritage_stories")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String dynastyEra;

    @Column(nullable = false)
    private String craftTheme;

    @Column(nullable = false)
    private String narrativeTone;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String storyContent;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Story() {}

    public Story(String userEmail, String title, String dynastyEra, String craftTheme, String narrativeTone, String storyContent) {
        this.userEmail = userEmail;
        this.title = title;
        this.dynastyEra = dynastyEra;
        this.craftTheme = craftTheme;
        this.narrativeTone = narrativeTone;
        this.storyContent = storyContent;
    }

    public Long getId() { return id; }
    public String getUserEmail() { return userEmail; }
    public String getTitle() { return title; }
    public String getDynastyEra() { return dynastyEra; }
    public String getCraftTheme() { return craftTheme; }
    public String getNarrativeTone() { return narrativeTone; }
    public String getStoryContent() { return storyContent; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}