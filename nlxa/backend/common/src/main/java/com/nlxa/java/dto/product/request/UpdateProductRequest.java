package com.nlxa.java.dto.product.request;


import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateProductRequest implements Serializable {

    private String productId;
    private String description;
    private float price;


    public UpdateProductRequest(String productId, String description, float price) {
        this.productId = productId;
        this.description = description;
        this.price = price;
    }
}
