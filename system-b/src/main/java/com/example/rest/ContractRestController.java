package com.example.rest;

import com.example.entity.Contract;
import com.example.service.ContractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/system-b")
public class ContractRestController {
    private final ContractService contractService;

    public ContractRestController(final ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/contractbykey")
    public ResponseEntity<Contract> getContractByKey(@RequestParam(name = "key") String contractKey) {
        Optional<Contract> contract = contractService.getContractByKey(contractKey);

        if (contract.isPresent()) {
            return ResponseEntity.ok(contract.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
