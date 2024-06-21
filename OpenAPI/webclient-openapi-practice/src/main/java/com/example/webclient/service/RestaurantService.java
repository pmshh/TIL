package com.example.webclient.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantService {

    private final WebClient.Builder webClientBuilder;  // WebClient를 빌드하기 위한 빌더를 주입받음

    @Value("${google.api.key}")
    private String apiKey;  // application.properties 파일에서 Google API 키를 주입받음

    public Mono<String> getRestaurantData(String location, int resultCount) {
        WebClient webClient = webClientBuilder.baseUrl("https://maps.googleapis.com").build();
        // WebClient 인스턴스를 빌더를 통해 생성

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/maps/api/place/nearbysearch/json")
                        .queryParam("location", location)
                        .queryParam("radius", 1500)
                        .queryParam("type", "restaurant")
                        .queryParam("key", apiKey)
                        .queryParam("maxresults", resultCount)
                        .build())
                // Google Places API에 요청을 보낼 URI를 구성
                .retrieve()
                .bodyToMono(String.class);
        // API 응답을 Mono<String>으로 반환
    }
}

