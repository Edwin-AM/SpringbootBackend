package com.nlxa.java.dto.client.request;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Data
public class DeleteClientRequest implements Serializable {

    private String clientId;

    public DeleteClientRequest() {
    }

    @Autowired
    public DeleteClientRequest(String clientId) {
        this.clientId = clientId;
    }
}
