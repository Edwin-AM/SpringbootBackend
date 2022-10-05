package com.nlxa.java.dto.product.response;

import com.nlxa.java.domain.Product;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class ProductResponse implements Serializable {

    private String productId;


    public ProductResponse() {
    }

    public ProductResponse(Product product) {
        setProductId(product.getProductId());
    }
}
