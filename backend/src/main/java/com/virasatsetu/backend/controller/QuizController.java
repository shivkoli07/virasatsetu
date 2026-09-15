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

import com.virasatsetu.backend.entity.QuizRecord;
import com.virasatsetu.backend.entity.User;
import com.virasatsetu.backend.entity.UserBadge;
import com.virasatsetu.backend.repository.QuizRecordRepository;
import com.virasatsetu.backend.repository.UserBadgeRepository;
import com.virasatsetu.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "*")
public class QuizController {

    @Autowired
    private QuizRecordRepository quizRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBadgeRepository badgeRepo;

    @PostMapping("/submit")
    public ResponseEntity<?> submitQuiz(@RequestBody Map<String, Object> payload) {
        String email = (String) payload.get("email");
        String title = (String) payload.get("title");
        String category = (String) payload.get("category");
        Integer scorePercent = (Integer) payload.get("scorePercent");
        Integer xpEarned = (Integer) payload.get("xpEarned");
        String badgeTitle = (String) payload.get("badgeTitle");
        String badgeIcon = (String) payload.getOrDefault("badgeIcon", "🏅");

        // 1. Record Quiz Attempt
        QuizRecord record = new QuizRecord(email, title, category, scorePercent, xpEarned);
        quizRecordRepository.save(record);

        // 2. Increment XP & Badge Count on User
        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null) {
            user.setTotalXp((user.getTotalXp() == null ? 0 : user.getTotalXp()) + xpEarned);

            // Save new badge if unlocked and not already earned
            if (badgeTitle != null && !badgeRepo.existsByUserEmailAndBadgeTitle(email, badgeTitle)) {
                badgeRepo.save(new UserBadge(email, badgeTitle, title, badgeIcon));
                user.setBadgesWon((user.getBadgesWon() == null ? 0 : user.getBadgesWon()) + 1);
            }
            userRepository.save(user);
            return ResponseEntity.ok(Map.of(
                "totalXp", user.getTotalXp(),
                "badgesWon", user.getBadgesWon()
            ));
        }

        return ResponseEntity.ok(Map.of("message", "Trial recorded"));
    }

  @GetMapping("/history")
public ResponseEntity<List<QuizRecord>> getQuizHistory(@RequestParam String email) {
    return ResponseEntity.ok(quizRecordRepository.findByUserEmailOrderByCompletedAtDesc(email));
}
    @GetMapping("/badges")
    public ResponseEntity<List<UserBadge>> getUserBadges(@RequestParam String email) {
        return ResponseEntity.ok(badgeRepo.findByUserEmail(email));
    }
}