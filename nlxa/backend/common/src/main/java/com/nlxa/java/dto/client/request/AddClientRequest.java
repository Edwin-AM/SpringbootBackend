package com.nlxa.java.dto.client.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddClientRequest implements Serializable {

    private String clientId;
    private String name;
    private String password;
    private String email;

    public AddClientRequest() {
    }

    public AddClientRequest(String clientId, String name, String password, String email) {
        this.clientId = clientId;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
