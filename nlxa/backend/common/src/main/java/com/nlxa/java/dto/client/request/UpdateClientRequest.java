package com.nlxa.java.dto.client.request;

import com.nlxa.java.domain.Invoice;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UpdateClientRequest implements Serializable {

    private String clientId;
    private String name;
    private String lastName;

    public UpdateClientRequest() {
    }

    public UpdateClientRequest(String clientId, String name, String lastName) {
        this.clientId = clientId;
        this.name = name;
        this.lastName = lastName;
    }
}
