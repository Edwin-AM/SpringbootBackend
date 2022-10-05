package com.nlxa.java.dto.client.response;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ClientDeleteResponse {

    private boolean result;

    public ClientDeleteResponse(boolean result) {
        this.result = result;
    }
}
