package com.example.openapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantService {

    private final RestTemplate restTemplate;

    @Value("${google.api.key}")
    private String apiKey;

    public String getRestaurantData(String location, int resultCount) {
        String apiUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + location + "&radius=1500&type=restaurant&key=" + apiKey + "&maxresults=" + resultCount;;
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
