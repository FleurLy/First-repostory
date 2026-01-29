package com.secureemailanalyzer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.secureemailanalyzer.dto.EmailAnalysisResult;

@Service
public class EmailAnalysisService {

    private static final Map<String, Integer> SUSPICIOUS_KEYWORDS = Map.of(
        "urgent", 2,
        "verify", 3,
        "password", 5,
        "click", 4,
        "account", 2,
        "bank", 5,
        "confirm", 3
    );

    // public String analyze(String emailContent) {
    //     String content = emailContent.toLowerCase();

    //     for (String keyword : SUSPICIOUS_KEYWORDS) {
    //         if (content.contains(keyword)) {
    //             return "⚠️ Email suspect détecté (mot-clé : " + keyword + ")";
    //         }
    //     }

    //     return "Email sécurisé";
    // }

    public EmailAnalysisResult analyze(String emailContent) {
        String content = emailContent.toLowerCase();
        int score = 0;
        List<String> foundKeywords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : SUSPICIOUS_KEYWORDS.entrySet()) {
            if (content.contains(entry.getKey())) {
                score += entry.getValue();
                foundKeywords.add(entry.getKey());
            }
        }

        boolean suspicious = score >= 5;
        String message = suspicious ? "⚠️ Email suspect détecté" : "Email sécurisé";

        return new EmailAnalysisResult(message, suspicious, score, foundKeywords);
    }
}
