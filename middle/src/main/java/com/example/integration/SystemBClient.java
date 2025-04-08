package com.example.integration;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class SystemBClient {
    private final RestClient client;

    public SystemBClient() {
        client = RestClient
            .builder()
            .baseUrl("http://localhost:8081/system-b")
            .build();
    }

    public ResponseEntity<String> getContract(String contractKey) {
        return client
            .get()
            .uri(uriBuilder -> uriBuilder
                .path("/contractbykey")
                .queryParam("key", contractKey)
                .build())
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .toEntity(String.class);
    }

//    public ResponseEntity<String> getContract(String contractKey) {
//        return client
//            .get()
//            .uri(uriBuilder -> uriBuilder
//                .path("/contractbykey")
//                .queryParam("key", contractKey)
//                .build())
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange((request, response) -> {
//                HttpStatusCode status = response.getStatusCode();
//                String body = response
//                    .getBody()
//                    .toString();
//                return ResponseEntity
//                    .status(status)
//                    .body(body);
//            });
//    }
}
