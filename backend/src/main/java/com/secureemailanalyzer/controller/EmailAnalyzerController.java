package com.secureemailanalyzer.controller;

import com.secureemailanalyzer.dto.EmailAnalysisResult;
import com.secureemailanalyzer.service.EmailAnalysisService;
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

    @PostMapping("/analyze")
    public String analyzeEmail(
            @RequestParam String emailContent,
            Model model) {

        EmailAnalysisResult result = emailAnalysisService.analyze(emailContent);
        model.addAttribute("result", result);

        return "analyze";
    }

}
