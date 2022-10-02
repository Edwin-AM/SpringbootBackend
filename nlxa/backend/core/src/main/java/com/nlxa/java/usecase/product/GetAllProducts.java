package com.nlxa.java.usecase.product;

import com.nlxa.java.dto.product.response.ProductListResponse;
import com.nlxa.java.product.ProductBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GetAllProducts {

    private ProductBusiness productBusiness;

    @Autowired
    public GetAllProducts(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    public ProductListResponse execute() {
        ProductListResponse productListResponse = null;

        try {
            productListResponse = this.productBusiness.getAllProducts();
        } catch (Exception ex) {
            log.error("Error in: GetAllProducts.execute()", ex);
        }

        return productListResponse;
    }
}
