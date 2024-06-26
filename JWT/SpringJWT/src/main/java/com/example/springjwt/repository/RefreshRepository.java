package com.example.springjwt.repository;

import com.example.springjwt.entity.RefreshEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface RefreshRepository extends JpaRepository<RefreshEntity, Long> {

    Boolean existsByRefresh(String refresh);

    @Transactional
    void deleteByRefresh(String refresh);

    @Transactional
    @Modifying
    @Query("DELETE FROM RefreshEntity t WHERE t.expiration < :now")
    void deleteExpiredTokens(LocalDateTime now);
}
