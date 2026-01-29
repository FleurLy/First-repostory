package com.secureemailanalyzer.controller;

import com.secureemailanalyzer.dto.EmailAnalysisResult;
import com.secureemailanalyzer.entity.EmailAnalysisEntity;
import com.secureemailanalyzer.service.EmailAnalysisService;

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

    public EmailAnalyzerController(EmailAnalysisService emailAnalysisService) {
        this.emailAnalysisService = emailAnalysisService;
    }

    @GetMapping("/analyze")
    public String showAnalyzePage() {
        return "analyze";
    }

    @GetMapping("/history")
    public String history(Model model, @AuthenticationPrincipal User user) {
        List<EmailAnalysisEntity> history = emailAnalysisService.getHistory(user.getUsername());
        model.addAttribute("history", history);
        return "history";
    }


    @PostMapping("/analyze")
    public String analyzeEmail(
            @RequestParam String emailContent,
            Model model, @AuthenticationPrincipal User user) {

        EmailAnalysisResult result = emailAnalysisService.analyze(emailContent, user.getUsername());
        model.addAttribute("result", result);

        return "analyze";
    }

}
