package com.learningplatform.backend.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Map;

@Service
public class OpenAiService {

    @Value("${openai.api.key}")
    private String openAiApiKey;

    private final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";

    public String generateLearningContent(String topic) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(openAiApiKey);

        String prompt = "Explícame cómo aprender " + topic + " con teoría, ejercicios y ejemplos de código.";

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", new Object[]{
                        Map.of("role", "system", "content", "Eres un tutor experto."),
                        Map.of("role", "user", "content", prompt)
                },
                "temperature", 0.7
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(OPENAI_URL, request, Map.class);
        var choices = (java.util.List<Map<String, Object>>) response.getBody().get("choices");

        if (choices != null && !choices.isEmpty()) {
            return (String) ((Map<String, Object>) choices.get(0).get("message")).get("content");
        }

        return "No se pudo generar contenido para este curso.";
    }
}
