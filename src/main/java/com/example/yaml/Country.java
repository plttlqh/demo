package com.example.yaml;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;

public class Country {
    @NotBlank
    private String id;
    @NotBlank
    private String code;
    @Valid
    private Document document;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
