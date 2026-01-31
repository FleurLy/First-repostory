package com.secureemailanalyzer.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.secureemailanalyzer.repository.EmailAnalysisRepository;

@Controller
public class HistoryController {

    private final EmailAnalysisRepository repo;

    public HistoryController(EmailAnalysisRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/history")
    public String history(
            @AuthenticationPrincipal UserDetails user,
            Model model) {

        model.addAttribute("history",
            repo.findByUsernameOrderByAnalyzedAtDesc(user.getUsername()));

        return "history";
    }
}
