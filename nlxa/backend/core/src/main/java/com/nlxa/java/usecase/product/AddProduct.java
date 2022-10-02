package com.nlxa.java.usecase.product;

import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.response.ClientResponse;
import com.nlxa.java.dto.product.request.AddProductRequest;
import com.nlxa.java.dto.product.response.ProductResponse;
import com.nlxa.java.product.ProductBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AddProduct {

    private ProductBusiness productBusiness;

    @Autowired
    public AddProduct(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    public ProductResponse execute(AddProductRequest request) {
        log.info("Call to: AddProduct.execute()");
        ProductResponse response = null;
        try {
            response = this.productBusiness.addProduct(request);
        }catch (Exception e){
            log.error("Error in: AddProduct.execute()", e);
        }
        return response;
    }
}
