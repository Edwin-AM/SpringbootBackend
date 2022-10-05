package com.nlxa.java.dto.product.response;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ProductDeleteResponse {

    private boolean result;

    public ProductDeleteResponse(boolean result) {
        this.result = result;
    }
}