package com.nlxa.java.usecase.product;

import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.response.ClientResponse;
import com.nlxa.java.dto.product.request.AddProductRequest;
import com.nlxa.java.dto.product.response.ProductResponse;
import com.nlxa.java.exceptions.IncompleteDataException;
import com.nlxa.java.product.ProductBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class AddProduct {

    private ProductBusiness productBusiness;

    @Autowired
    public AddProduct(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    /**
     * Tries to insert a Product, validating its data.
     *
     * @param request AddProductRequest
     * @return Future<ProductResponse>
     * @throws IncompleteDataException
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    public Future<ProductResponse> execute(AddProductRequest request) throws IncompleteDataException,
            IllegalArgumentException, NullPointerException{
        log.info("Call to: AddProduct.execute()");
        AsyncResponse<ProductResponse> response = null;

        if (request == null) {
            throw new IllegalArgumentException("Null parameter in -> AddProduct.execute()");
        }

        if (request.getProductId().equalsIgnoreCase("") ||
                request.getPrice() <= 0 ||
                request.getProductName().equalsIgnoreCase("")
        ) {
            throw new IncompleteDataException("Missing data -> In AddProduct.execute()");
        }
        response = new AsyncResponse<>(this.productBusiness.addProduct(request));
        return response;
    }
}
