package com.example.rest;

import com.example.model.ResponseModel;
import com.example.service.KeyService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/middle")
public class KeyRestController {
    private final KeyService keyService;

    public KeyRestController(final KeyService inKeyService) {
        keyService = inKeyService;
    }

    @GetMapping("/check-matching-key")
    public ResponseEntity<ResponseModel> findMatch(@RequestParam(name = "key") String contractKey) {
        ResponseModel result;

        try {
            result = keyService.handleKeyRequest(contractKey);

            return new ResponseEntity<>(result, result.status());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(500));
        }
    }
}
