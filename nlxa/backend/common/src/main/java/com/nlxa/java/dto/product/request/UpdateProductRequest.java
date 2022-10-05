package com.nlxa.java.dto.product.request;


import com.nlxa.java.domain.Detail;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateProductRequest implements Serializable {

    private String productId;
    private String productName;
    private float price;

    public UpdateProductRequest() {
    }


    public UpdateProductRequest(String productId, String productName, float price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }
}
