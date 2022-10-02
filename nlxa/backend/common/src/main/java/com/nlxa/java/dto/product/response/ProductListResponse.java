package com.nlxa.java.dto.product.response;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductListResponse implements Serializable {

    private List<ProductResponse> productResponseList;

    public ProductListResponse() {
        this.productResponseList = new ArrayList<>();
    }

    public ProductListResponse(List<ProductResponse> productResponseList) {
        this.productResponseList = productResponseList;
    }
}
