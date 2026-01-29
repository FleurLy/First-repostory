package com.secureemailanalyzer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secureemailanalyzer.entity.EmailAnalysisEntity;

public interface EmailAnalysisRepository extends JpaRepository<EmailAnalysisEntity, Long> {
    List<EmailAnalysisEntity> findByUsernameOrderByAnalyzedAtDesc(String username);
}
