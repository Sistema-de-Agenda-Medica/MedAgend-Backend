package com.br.medagend.response;

import java.util.UUID;

public class SignupResponse {

    private UUID id;
    private String name;
    private String email;
    private String type;
    private String contact;
    private String createdIn;

    public SignupResponse(UUID id, String name, String email, String type, String contact, String createdIn) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
        this.contact = contact;
        this.createdIn = createdIn;
    }

    public SignupResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(String createdIn) {
        this.createdIn = createdIn;
    }
}
