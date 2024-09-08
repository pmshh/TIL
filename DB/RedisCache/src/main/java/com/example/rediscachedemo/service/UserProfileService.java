package com.example.rediscachedemo.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    // 프로필 조회 시 캐시 사용
    @Cacheable(value = "userProfiles", key = "#userId")
    public String getUserProfile(String userId) throws InterruptedException {
        Thread.sleep(3000); // 실제 서비스에서 지연이 발생하는 상황을 시뮬레이션
        return "User Profile for ID: " + userId;
    }

    // 프로필 업데이트 시 캐시 무효화
    @CacheEvict(value = "userProfiles", key = "#userId")
    public void updateUserProfile(String userId, String newProfileData) {
        System.out.println("User profile updated for ID: " + userId + " with data: " + newProfileData);
    }
}