package com.nlxa.java.usecase.product;

import com.nlxa.java.domain.Product;
import com.nlxa.java.dto.product.request.AddProductRequest;
import com.nlxa.java.dto.product.request.UpdateProductRequest;
import com.nlxa.java.dto.product.response.ProductResponse;
import com.nlxa.java.product.ProductBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UpdateProduct {

    private ProductBusiness productBusiness;

    @Autowired
    public UpdateProduct(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    public ProductResponse execute(UpdateProductRequest request) {
        log.info("Call to: UpdateProduct.execute()");
        ProductResponse response = null;
        try {
            response = this.productBusiness.updateProduct(request);
        }catch (Exception e){
            log.error("Error in: UpdateProduct.execute()", e);
        }
        return response;
    }
}
