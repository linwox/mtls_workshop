package com.example.service;

import com.example.integration.SystemBClient;
import com.example.model.ContractId;
import com.example.model.ResponseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class KeyService {
    private SystemBClient client;

    public KeyService(final SystemBClient inClient) {
        client = inClient;
    }

    public ResponseModel handleKeyRequest(String contractKey) {
        try {
            ResponseEntity<String> externalResponse = client.getContract(contractKey);
            HttpStatusCode status = externalResponse.getStatusCode();
            String responseBody = externalResponse.getBody();

            if (status.is2xxSuccessful()) {
                Long contractId = extractContractId(responseBody).id();
                String contractUrl = buildUrl(contractId);

                return new ResponseModel(status, contractId, contractUrl);
            } else {
                return new ResponseModel(status, null, null);
            }
        } catch (Exception inE) {
            throw new RuntimeException(inE);
        }
    }

    private ContractId extractContractId(final String responseBody) {
        ObjectMapper mapper = new ObjectMapper();

        ContractId contractId;
        try {
            contractId = mapper.readValue(responseBody, ContractId.class);
        } catch (JsonProcessingException inE) {
            throw new RuntimeException(inE);
        }
        return contractId;
    }

    public String buildUrl(Long id) {
        return "http://system-b/contract/" + id + "/";
    }
}
