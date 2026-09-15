package com.virasatsetu.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "heritage_user_badges")
public class UserBadge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "badge_title", nullable = false)
    private String badgeTitle;

    @Column(name = "badge_subtitle")
    private String badgeSubtitle;

    @Column(name = "badge_icon")
    private String badgeIcon;

    @Column(name = "earned_at")
    private LocalDateTime earnedAt = LocalDateTime.now();

    public UserBadge() {}

    public UserBadge(String userEmail, String badgeTitle, String badgeSubtitle, String badgeIcon) {
        this.userEmail = userEmail;
        this.badgeTitle = badgeTitle;
        this.badgeSubtitle = badgeSubtitle;
        this.badgeIcon = badgeIcon;
    }

    public Long getId() { return id; }
    public String getUserEmail() { return userEmail; }
    public String getBadgeTitle() { return badgeTitle; }
    public String getBadgeSubtitle() { return badgeSubtitle; }
    public String getBadgeIcon() { return badgeIcon; }
    public LocalDateTime getEarnedAt() { return earnedAt; }
}