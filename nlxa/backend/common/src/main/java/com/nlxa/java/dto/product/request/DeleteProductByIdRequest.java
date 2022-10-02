package com.nlxa.java.dto.product.request;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Data
public class DeleteProductByIdRequest implements Serializable {

    private String productId;
    @Autowired
    public DeleteProductByIdRequest(String productId) {
        this.productId = productId;
    }
}
