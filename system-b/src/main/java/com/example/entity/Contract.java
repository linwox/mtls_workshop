package com.example.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String contractKey;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(final Long inId) {
        id = inId;
    }

    public String getContractKey() {
        return contractKey;
    }

    public void setContractKey(final String inContractKey) {
        contractKey = inContractKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String inTitle) {
        title = inTitle;
    }
}
