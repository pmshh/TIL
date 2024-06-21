package com.example.openapi.controller;

import com.example.openapi.dto.RestaurantDTO;
import com.example.openapi.service.RestaurantService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantDTO> getRestaurants(@RequestParam String location, @RequestParam int resultCount) throws JsonProcessingException {
        String apiResponse = restaurantService.getRestaurantData(location, resultCount);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(apiResponse);
        JsonNode results = root.path("results");

        List<RestaurantDTO> restaurants = new ArrayList<>();
        for (JsonNode result : results) {
            double rating = result.path("rating").asDouble();
            if (rating >= 4.0) {
                RestaurantDTO restaurant = new RestaurantDTO();
                restaurant.setName(result.path("name").asText());
                restaurant.setAddress(result.path("vicinity").asText());
                restaurant.setRating(rating);
                restaurants.add(restaurant);
            }
        }
        return restaurants.subList(0, Math.min(resultCount, restaurants.size()));
    }
}
