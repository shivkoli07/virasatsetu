package com.virasatsetu.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "heritage_sites")
public class HeritageSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String eraOrPeriod;
    private String imageUrl;

    public HeritageSite() {}

    public HeritageSite(String name, String state, String category, Double latitude, Double longitude, String description, String eraOrPeriod, String imageUrl) {
        this.name = name;
        this.state = state;
        this.category = category;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.eraOrPeriod = eraOrPeriod;
        this.imageUrl = imageUrl;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getState() { return state; }
    public String getCategory() { return category; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
    public String getDescription() { return description; }
    public String getEraOrPeriod() { return eraOrPeriod; }
    public String getImageUrl() { return imageUrl; }
}