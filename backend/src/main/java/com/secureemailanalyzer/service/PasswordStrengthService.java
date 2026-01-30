package com.secureemailanalyzer.service;

import org.springframework.stereotype.Service;

@Service
public class PasswordStrengthService {

    public boolean isStrong(String password) {
        if (password == null) return false;

        return password.length() >= 8
            && password.matches(".*[A-Z].*")
            && password.matches(".*[a-z].*")
            && password.matches(".*\\d.*")
            && password.matches(".*[^a-zA-Z0-9].*");
    }
}
