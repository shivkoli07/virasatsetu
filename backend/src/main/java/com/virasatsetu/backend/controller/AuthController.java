package com.virasatsetu.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virasatsetu.backend.entity.User;
import com.virasatsetu.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String fullName = payload.get("fullName");
        String rawPassword = payload.get("password");

        if (email == null || rawPassword == null || fullName == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "All fields are required."));
        }

        if (userRepository.existsByEmail(email)) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email is already registered."));
        }

        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(rawPassword));

        userRepository.save(user);
        return ResponseEntity.ok(Map.of("message", "Account registered successfully."));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String rawPassword = payload.get("password");

        return userRepository.findByEmail(email)
            .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword()))
            .map(user -> ResponseEntity.ok(Map.of(
                "message", "Login successful",
                "fullName", user.getFullName(),
                "email", user.getEmail()
            )))
            .orElseGet(() -> ResponseEntity.status(401).body(Map.of("message", "Invalid email or password.")));
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(@RequestParam String email) {
        return userRepository.findByEmail(email)
            .map(user -> ResponseEntity.ok(Map.of(
                "fullName", user.getFullName() != null ? user.getFullName() : "",
                "email", user.getEmail(),
                "phone", user.getPhone() != null ? user.getPhone() : "",
                "education", user.getEducation() != null ? user.getEducation() : "",
                "interest", user.getInterest() != null ? user.getInterest() : "",
                "address", user.getAddress() != null ? user.getAddress() : "",
                "avatarBase64", user.getAvatarBase64() != null ? user.getAvatarBase64() : "",
                "totalXp", user.getTotalXp() != null ? user.getTotalXp() : 0,
                "badgesWon", user.getBadgesWon() != null ? user.getBadgesWon() : 0
            )))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/profile")
    public ResponseEntity<?> updateProfile(@RequestBody Map<String, Object> payload) {
        String email = (String) payload.get("email");
        if (email == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email is required."));
        }

        return userRepository.findByEmail(email).map(user -> {
            if (payload.containsKey("fullName")) user.setFullName((String) payload.get("fullName"));
            if (payload.containsKey("phone")) user.setPhone((String) payload.get("phone"));
            if (payload.containsKey("education")) user.setEducation((String) payload.get("education"));
            if (payload.containsKey("interest")) user.setInterest((String) payload.get("interest"));
            if (payload.containsKey("address")) user.setAddress((String) payload.get("address"));
            if (payload.containsKey("avatarBase64")) user.setAvatarBase64((String) payload.get("avatarBase64"));

            userRepository.save(user);
            return ResponseEntity.ok(Map.of("message", "Profile successfully synchronized with database."));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}