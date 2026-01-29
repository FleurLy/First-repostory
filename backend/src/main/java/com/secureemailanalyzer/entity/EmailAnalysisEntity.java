package com.secureemailanalyzer.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmailAnalysisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // utilisateur qui a analysé
    @Column(length = 5000)
    private String content;
    private boolean suspicious;
    private int score;

    @ElementCollection
    private List<String> reasons;

    private LocalDateTime analyzedAt = LocalDateTime.now();

    // getters / setters

    public LocalDateTime getDate(){
        return analyzedAt;
    }
}
