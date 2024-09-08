package com.example.rediscachedemo.controller;

import com.example.rediscachedemo.service.UserProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("/users/{userId}")
    public String getUserProfile(@PathVariable String userId) throws InterruptedException {
        return userProfileService.getUserProfile(userId);
    }

    // 프로필 업데이트 API (캐시 무효화)
    @PostMapping("/users/{userId}/update")
    public String updateUserProfile(@PathVariable String userId, @RequestParam String newProfileData) {
        userProfileService.updateUserProfile(userId, newProfileData);
        return "User profile updated for ID: " + userId;
    }
}
