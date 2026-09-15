package com.virasatsetu.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virasatsetu.backend.entity.HeritageSite;
import com.virasatsetu.backend.repository.HeritageSiteRepository;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/heritage")
@CrossOrigin(origins = "*")
public class HeritageMapController {

    @Autowired
    private HeritageSiteRepository siteRepository;

    @PostConstruct
    public void seedInitialSites() {
        if (siteRepository.count() == 0) {
            siteRepository.saveAll(List.of(
                new HeritageSite(
                    "Ellora & Kailasa Temple", "Maharashtra", "Monuments & Architecture",
                    20.0268, 75.1790,
                    "Largest monolithic rock-cut cave structure chiseled from a single basalt cliffside.",
                    "Rashtrakuta Dynasty (8th Century)",
                    "https://images.unsplash.com/photo-1590077428593-a55bb07c4665?w=600&q=80"
                ),
                new HeritageSite(
                    "Brihadisvara Temple", "Tamil Nadu", "Monuments & Architecture",
                    10.7828, 79.1318,
                    "Granite Dravidian vimana crowning tower standing entirely without binding mortar.",
                    "Imperial Chola Dynasty (1010 CE)",
                    "https://images.unsplash.com/photo-1621847468516-1ed5d0df56fe?w=600&q=80"
                ),
                new HeritageSite(
                    "Warli Tribal Canvas Clusters", "Maharashtra", "Tribal & Indigenous Heritage",
                    19.9975, 72.8223,
                    "Ritual ochre clay murals and geometric cosmic cycles rendered in white rice paste.",
                    "Ancient Indigenous Roots (10th Century)",
                    "https://images.unsplash.com/photo-1579783900882-c0d3dad7b119?w=600&q=80"
                ),
                new HeritageSite(
                    "Konark Sun Temple", "Odisha", "Archaeological Heritage",
                    19.8876, 86.0945,
                    "Colossal stone chariot with 24 carved wheels functioning as precise sundials.",
                    "Eastern Ganga Dynasty (1250 CE)",
                    "https://images.unsplash.com/photo-1606298855672-3efb63017be8?w=600&q=80"
                ),
                new HeritageSite(
                    "Paithani Silk & Zari Centers", "Maharashtra", "Textiles & Weaving",
                    19.4795, 75.3854,
                    "Pure mulberry silk handloom with real gold and silver zari pallu motifs.",
                    "Satavahana Era Tradition",
                    "https://images.unsplash.com/photo-1610030469983-98e550d6193c?w=600&q=80"
                )
            ));
        }
    }

    @GetMapping("/sites")
    public ResponseEntity<List<HeritageSite>> getAllSites() {
        return ResponseEntity.ok(siteRepository.findAll());
    }

    @GetMapping("/sites/state/{state}")
    public ResponseEntity<List<HeritageSite>> getSitesByState(@PathVariable String state) {
        return ResponseEntity.ok(siteRepository.findByStateIgnoreCase(state));
    }
}