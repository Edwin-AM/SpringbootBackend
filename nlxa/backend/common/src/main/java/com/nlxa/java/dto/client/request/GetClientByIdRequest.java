package com.nlxa.java.dto.client.request;

import lombok.Data;

@Data
public class GetClientByIdRequest {

    private String clientId;

    public GetClientByIdRequest() {
    }

    public GetClientByIdRequest(String clientId) {
        this.clientId = clientId;
    }
}
