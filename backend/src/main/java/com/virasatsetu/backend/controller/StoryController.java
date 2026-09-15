package com.virasatsetu.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virasatsetu.backend.entity.Story;
import com.virasatsetu.backend.repository.StoryRepository;

@RestController
@RequestMapping("/api/stories")
@CrossOrigin(origins = "*")
public class StoryController {

    @Autowired
    private StoryRepository storyRepository;

    @PostMapping("/generate")
    public ResponseEntity<?> generateAndSaveStory(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String era = payload.get("era");
        String theme = payload.get("theme");
        String tone = payload.get("tone");

        if (email == null || era == null || theme == null || tone == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "All parameters are required."));
        }

        // Narrative generation engine
        String generatedTitle = String.format("Echoes of %s: The Legacy of %s", era, theme);
        String narrative = buildHeritageEpic(era, theme, tone);

        Story story = new Story(email, generatedTitle, era, theme, tone, narrative);
        Story saved = storyRepository.save(story);

        return ResponseEntity.ok(Map.of(
            "message", "Epic synthesized and chronicled to database!",
            "story", saved
        ));
    }

    @GetMapping("/my-library")
    public ResponseEntity<List<Story>> getLibrary(@RequestParam String email) {
        return ResponseEntity.ok(storyRepository.findByUserEmailOrderByCreatedAtDesc(email));
    }

    private String buildHeritageEpic(String era, String theme, String tone) {
        return String.format(
            "Under the sovereign dominion of the %s, the artisan guilds of the realm flourished along sacred riverbanks. " +
            "Focused on the sacred practice of %s, master craftsmen worked with rare devotion. Written in a %s cadence, " +
            "the oral chronicles recall how every stroke, chisel, and melody embodied civilizational memory—preserving timeless " +
            "rituals and tangible monuments that still resonate through the sanctums and living traditions of Bharat.",
            era, theme, tone
        );
    }
}