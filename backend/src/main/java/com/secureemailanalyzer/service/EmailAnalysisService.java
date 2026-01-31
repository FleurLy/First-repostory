package com.secureemailanalyzer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.secureemailanalyzer.dto.EmailAnalysisResult;
import com.secureemailanalyzer.entity.EmailAnalysisEntity;
import com.secureemailanalyzer.repository.EmailAnalysisRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


// @Service
// public class EmailAnalysisService {

//     private static final Map<String, Integer> SUSPICIOUS_KEYWORDS = Map.of(
//         "urgent", 2,
//         "verify", 3,
//         "password", 5,
//         "click", 4,
//         "account", 2,
//         "bank", 5,
//         "confirm", 3
//     );

//     // public String analyze(String emailContent) {
//     //     String content = emailContent.toLowerCase();

//     //     for (String keyword : SUSPICIOUS_KEYWORDS) {
//     //         if (content.contains(keyword)) {
//     //             return "⚠️ Email suspect détecté (mot-clé : " + keyword + ")";
//     //         }
//     //     }

//     //     return "Email sécurisé";
//     // }

//     public EmailAnalysisResult analyze(String emailContent) {
//         String content = emailContent.toLowerCase();
//         int score = 0;
//         List<String> foundKeywords = new ArrayList<>();

//         for (Map.Entry<String, Integer> entry : SUSPICIOUS_KEYWORDS.entrySet()) {
//             if (content.contains(entry.getKey())) {
//                 score += entry.getValue();
//                 foundKeywords.add(entry.getKey());
//             }
//         }

//         boolean suspicious = score >= 5;
//         String message = suspicious ? "⚠️ Email suspect détecté" : "Email sécurisé";

//         return new EmailAnalysisResult(message, suspicious, score, foundKeywords);
//     }
// }

@Service
public class EmailAnalysisService {

    private final EmailAnalysisRepository repo;
    private static final Map<String, Integer> SUSPICIOUS_KEYWORDS = Map.of(
        "urgent", 2,
        "verify", 3,
        "password", 5,
        "click", 4,
        "account", 2,
        "bank", 5,
        "confirm", 3
    );

    public EmailAnalysisService(EmailAnalysisRepository repo) {
        this.repo = repo;
    }

    public EmailAnalysisResult analyze(String emailContent, String username) {
        // calcul du score comme avant
        int score = 0;
        List<String> foundKeywords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : SUSPICIOUS_KEYWORDS.entrySet()) {
            String content = emailContent.toLowerCase();

            if (content.contains(entry.getKey())) {
            // if (emailContent.contains(entry.getKey())) {
                score += entry.getValue();
                foundKeywords.add(entry.getKey());
            }
        }

        // Détection des liens
        Pattern linkPattern = Pattern.compile("(https?:\\/\\/\\S+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = linkPattern.matcher(emailContent);

        while (matcher.find()) {
            score += 4;
            foundKeywords.add("Lien suspect : " + matcher.group());
        }


        boolean suspicious = score >= 5;
        String message = suspicious ? "⚠️ Email suspect détecté" : "Email sécurisé";
        EmailAnalysisResult result = new EmailAnalysisResult(message, suspicious, score, foundKeywords);
        

        EmailAnalysisEntity entity = new EmailAnalysisEntity();
        entity.setUsername(username);
        entity.setContent(emailContent);
        entity.setSuspicious(result.isSuspicious());
        entity.setScore(result.getScore());
        entity.setReasons(result.getReasons());

        repo.save(entity);

        return result;
    }

    public EmailAnalysisRepository getRepo(){
        return repo;
    }

    public List<EmailAnalysisEntity> getHistory(String username) {
        return repo.findByUsernameOrderByAnalyzedAtDesc(username);
    }
}
