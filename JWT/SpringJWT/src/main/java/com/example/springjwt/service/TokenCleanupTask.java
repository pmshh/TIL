package com.example.springjwt.service;

import com.example.springjwt.repository.RefreshRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenCleanupTask {

    private final RefreshRepository refreshRepository;

    @Scheduled(cron = "0 * * * * *")
    public void deleteExpiredTokens() {
        LocalDateTime now = LocalDateTime.now();
        refreshRepository.deleteExpiredTokens(now);
        log.info("expired token deleted");
    }
}