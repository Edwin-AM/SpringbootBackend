package com.nlxa.java.dto.client.response;

import com.nlxa.java.domain.Client;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Data
public class ClientResponse {

    private String clientId;
    private String name;
    private String password;
    private String email;

    public ClientResponse() {
    }

    public ClientResponse(Client client) {
        this.clientId = client.getClientId();
        this.name = client.getName();
        this.password = client.getPassword();
        this.email = client.getEmail();
    }
}
