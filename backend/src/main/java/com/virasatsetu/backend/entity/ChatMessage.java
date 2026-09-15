package com.virasatsetu.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "heritage_chat_logs")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String userQuery;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String botResponse;

    private LocalDateTime timestamp = LocalDateTime.now();

    public ChatMessage() {}

    public ChatMessage(String userEmail, String userQuery, String botResponse) {
        this.userEmail = userEmail;
        this.userQuery = userQuery;
        this.botResponse = botResponse;
    }

    public Long getId() { return id; }
    public String getUserEmail() { return userEmail; }
    public String getUserQuery() { return userQuery; }
    public String getBotResponse() { return botResponse; }
    public LocalDateTime getTimestamp() { return timestamp; }
}