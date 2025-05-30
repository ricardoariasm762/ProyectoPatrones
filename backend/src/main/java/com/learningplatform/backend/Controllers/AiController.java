package com.learningplatform.backend.Controllers;

import com.learningplatform.backend.Services.OpenRouterAIService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*") // Para permitir peticiones desde Angular
@RequestMapping("/api/ai")
public class AiController {

    private final OpenRouterAIService aiService;

    public AiController(OpenRouterAIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/ask")
    public ResponseEntity<String> askAi(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");

        try {
            String response = aiService.askModel(prompt);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("Error al consultar la IA: " + ex.getMessage());
        }
    }
}
