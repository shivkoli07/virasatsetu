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

import com.virasatsetu.backend.entity.ChatMessage;
import com.virasatsetu.backend.repository.ChatMessageRepository;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*")
public class ChatController {

    @Autowired
    private ChatMessageRepository chatRepo;

    @PostMapping("/chat")
    public ResponseEntity<?> handleChat(@RequestBody Map<String, String> payload) {
        String query = payload.get("message");
        String email = payload.getOrDefault("email", "guest@virasatsetu.in");

        if (query == null || query.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Query cannot be empty"));
        }

        String answer = generateHeritageAnswer(query.toLowerCase());

        ChatMessage record = new ChatMessage(email, query, answer);
        chatRepo.save(record);

        return ResponseEntity.ok(Map.of("reply", answer));
    }

    @GetMapping("/history")
    public ResponseEntity<List<ChatMessage>> getHistory(@RequestParam String email) {
        return ResponseEntity.ok(chatRepo.findByUserEmailOrderByTimestampAsc(email));
    }

    private String generateHeritageAnswer(String q) {
        if (q.contains("warli") || q.contains("painting")) {
            return "Warli painting is an ancient indigenous art form from the North Sahyadri Range of Maharashtra. Primarily painted by women (Savasinis), it uses basic geometric shapes—circles representing the sun and moon, triangles from mountains and trees, and squares denoting sacred enclosures (Chauk)—painted with white rice paste on mud ochre walls.";
        } else if (q.contains("chola") || q.contains("bronze") || q.contains("brihadisvara")) {
            return "The Imperial Chola dynasty (9th–13th century) pioneered the lost-wax (cire-perdue) bronze casting technique, famously giving the world the iconic Nataraja. Rajaraja Chola I constructed the magnificent granite Brihadisvara Temple in Thanjavur in 1010 CE without binding mortar.";
        } else if (q.contains("temple") || q.contains("nagara") || q.contains("dravidian")) {
            return "Indian temple architecture flourished under three principal styles: Nagara (curvilinear spires in Northern India crowned by an Amalaka and Kalasha), Dravidian (pyramidal stepped vimana towers with gopuram gateways in Southern India), and Vesara (a hybrid style refined by the Chalukyas and Hoysalas).";
        } else if (q.contains("paithani") || q.contains("silk") || q.contains("textile")) {
            return "Paithani is a handwoven silk saree originating from Paithan, Maharashtra, dating back to the Satavahana era. It is characterized by borders of oblique square design and a pallu featuring peacock, parrot, and lotus motifs woven with pure gold and silver zari.";
        } else {
            return "According to the VirasatSetu archives, Indian civilizational heritage encompasses 16 key tangible and intangible domains—ranging from Vedic oral chants and temple stone geometry to indigenous handlooms and tribal knowledge systems. How can I help you explore further?";
        }
    }
}