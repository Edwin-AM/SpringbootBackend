package com.nlxa.java.usecase.product;

import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.domain.Product;
import com.nlxa.java.dto.product.request.AddProductRequest;
import com.nlxa.java.dto.product.request.UpdateProductRequest;
import com.nlxa.java.dto.product.response.ProductResponse;
import com.nlxa.java.exceptions.IncompleteDataException;
import com.nlxa.java.product.ProductBusiness;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class UpdateProduct {

    private ProductBusiness productBusiness;

    @Autowired
    public UpdateProduct(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    /**
     * Tries to update a Product, validating its data
     *
     * @param request UpdateProductRequest
     * @return Future<ProductResponse>
     * @throws IncompleteDataException
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    public Future<ProductResponse> execute(UpdateProductRequest request) throws IncompleteDataException,
            IllegalArgumentException, NullPointerException {
        log.info("Call to: UpdateProduct.execute()");
        AsyncResponse<ProductResponse> response = null;

        if (request == null) {
            throw new IllegalArgumentException("Null parameter in -> UpdateProduct.execute()");
        }

        if (request.getPrice() <= 0 ||
                request.getProductId().equalsIgnoreCase("") ||
                request.getProductName().equalsIgnoreCase("")
        ) {
            throw new IncompleteDataException("Missing data -> In UpdateProduct.execute()");
        }
        response = new AsyncResponse<>(this.productBusiness.updateProduct(request));
        return response;
    }
}
