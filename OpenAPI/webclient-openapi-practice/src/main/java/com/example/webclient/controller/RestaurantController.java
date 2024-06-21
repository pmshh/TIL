package com.example.webclient.controller;

import com.example.webclient.dto.RestaurantDto;
import com.example.webclient.service.RestaurantService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;  // RestaurantService 인스턴스를 주입받음

    @GetMapping("/restaurants")
    public Mono<List<RestaurantDto>> getRestaurants(@RequestParam String location, @RequestParam int resultCount) {
        return restaurantService.getRestaurantData(location, resultCount)
                // RestaurantService의 메서드를 호출하여 데이터를 가져옴
                .flatMap(apiResponse -> {
                    ObjectMapper objectMapper = new ObjectMapper();
                    List<RestaurantDto> restaurants = new ArrayList<>();
                    try {
                        JsonNode root = objectMapper.readTree(apiResponse);
                        JsonNode results = root.path("results");

                        for (JsonNode result : results) {
                            double rating = result.path("rating").asDouble();
                            if (rating >= 4.0) {
                                RestaurantDto restaurant = new RestaurantDto();
                                restaurant.setName(result.path("name").asText());
                                restaurant.setAddress(result.path("vicinity").asText());
                                restaurant.setRating(rating);
                                restaurants.add(restaurant);
                            }
                        }
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return Mono.just(restaurants.subList(0, Math.min(resultCount, restaurants.size())));
                });
    }
}


