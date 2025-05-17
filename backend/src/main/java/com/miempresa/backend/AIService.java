package com.miempresa.backend;
import org.springframework.stereotype.Service;

@Service
public class AIService {
    private static AIService instance;

    private AIService() {} // Constructor privado

    public static synchronized AIService getInstance() {
        if (instance == null) {
            instance = new AIService();
        }
        return instance;
    }

    public int evaluate(String problem, String answer) {
        // Lógica de OpenAI (ej: usar RestTemplate)
        return (int) (Math.random() * 10); // Ejemplo temporal
    }
}