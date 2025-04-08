package com.example.service;

import com.example.data.ContractRepository;
import com.example.entity.Contract;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;

    public ContractServiceImpl(final ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Optional<Contract> getContractByKey(final String contractKey) {
        return contractRepository.findByContractKey(contractKey);
    }
}
