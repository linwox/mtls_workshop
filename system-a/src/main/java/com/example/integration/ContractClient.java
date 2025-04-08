package com.example.integration;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ContractClient {
    private final RestClient client;

    public ContractClient() {
        client = RestClient
            .builder()
            .baseUrl("http://localhost:8083/middle")
            .build();
    }

    public ResponseEntity<String> getContract(String contractKey) {
        return client
            .get()
            .uri(uriBuilder -> uriBuilder
                .path("/check-matching-key")
                .queryParam("key", contractKey)
            .build())
            .retrieve()
            .toEntity(String.class);
    }
}
