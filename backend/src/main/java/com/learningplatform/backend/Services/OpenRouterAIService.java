package com.learningplatform.backend.Services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OpenRouterAIService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey = "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"; // ⚠️ reemplázalo por tu clave

    public String askModel(String prompt) {
        String url = "https://openrouter.ai/api/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("HTTP-Referer", "https://tu-sitio.com"); // requerido por OpenRouter

        Map<String, Object> request = new HashMap<>();
        request.put("model", "mistralai/mistral-7b-instruct"); // modelo gratuito

        List<Map<String, String>> messages = new ArrayList<>();
        messages.add(Map.of("role", "user", "content", prompt));
        request.put("messages", messages);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(url, entity, Map.class);

        Map<String, Object> choice = (Map<String, Object>) ((List<?>) response.getBody().get("choices")).get(0);
        Map<String, String> message = (Map<String, String>) choice.get("message");
        return message.get("content");
    }
}
