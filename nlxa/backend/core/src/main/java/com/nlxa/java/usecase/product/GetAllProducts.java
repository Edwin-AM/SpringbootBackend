package com.nlxa.java.usecase.product;

import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.product.response.ProductListResponse;
import com.nlxa.java.product.ProductBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class GetAllProducts {

    private ProductBusiness productBusiness;

    @Autowired
    public GetAllProducts(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    /**
     * Tries to return a ProductListResponse
     *
     * @return ProductListResponse
     */
    public Future<ProductListResponse> execute() {
        AsyncResponse<ProductListResponse> response = null;

        try {
            response = new AsyncResponse<>(this.productBusiness.getAllProducts());
        } catch (Exception e) {
            log.error("Error in GetAllProducts.execute -> "+ e.getMessage());
        }

        return response;
    }
}
