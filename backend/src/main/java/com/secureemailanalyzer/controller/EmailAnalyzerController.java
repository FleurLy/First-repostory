package com.secureemailanalyzer.controller;

import com.secureemailanalyzer.dto.EmailAnalysisResult;
import com.secureemailanalyzer.entity.EmailAnalysisEntity;
import com.secureemailanalyzer.repository.EmailAnalysisRepository;
import com.secureemailanalyzer.service.EmailAnalysisService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailAnalyzerController {

    private final EmailAnalysisService emailAnalysisService;
    private final EmailAnalysisRepository emailAnalysisRepository;

    public EmailAnalyzerController(EmailAnalysisService emailAnalysisService, EmailAnalysisRepository emailAnalysisRepository) {
        this.emailAnalysisService = emailAnalysisService;
        this.emailAnalysisRepository = emailAnalysisRepository;
    }

    @GetMapping("/analyze")
    public String showAnalyzePage() {
        return "analyze";
    }

    


    @PostMapping("/analyze")
    public String analyzeEmail(
            @RequestParam String emailContent,
            Model model, @AuthenticationPrincipal User user) {
            
        if (user == null) {
            return "redirect:/login";
        }
        EmailAnalysisResult result = emailAnalysisService.analyze(emailContent, user.getUsername());
        // EmailAnalysisEntity entity = new EmailAnalysisEntity();
        // entity.setUsername(user.getUsername());
        // entity.setContent(emailContent);
        // entity.setScore(result.getScore());
        // entity.setSuspicious(result.isSuspicious());
        // entity.setDate(LocalDateTime.now());

        // emailAnalysisRepository.save(entity);
        model.addAttribute("result", result);

        return "analyze";
    }

}
