package com.example.service;

import com.example.entity.Contract;

import java.util.Optional;

public interface ContractService {
    public Optional<Contract> getContractByKey(String contractKey);
}
