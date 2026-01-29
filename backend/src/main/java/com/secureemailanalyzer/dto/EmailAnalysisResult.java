package com.secureemailanalyzer.dto;

import java.util.ArrayList;
import java.util.List;

public class EmailAnalysisResult {
    private String message;
    private boolean suspicious;
    private int score;
    private List<String> reasons;

    public EmailAnalysisResult(String message, boolean suspicious, int score, List<String> reasons) {
        this.message = message;
        this.suspicious = suspicious;
        this.score = score;
        this.reasons = reasons;
    }

    // getters
    public String getMessage() { return message; }
    public boolean isSuspicious() { return suspicious; }
    public int getScore() { return score; }
    public List<String> getReasons() { return reasons; }
}
