package com.example.model;

import org.springframework.http.HttpStatusCode;

public record ResponseModel(HttpStatusCode status, Long contractId, String contractUrl) {
}
