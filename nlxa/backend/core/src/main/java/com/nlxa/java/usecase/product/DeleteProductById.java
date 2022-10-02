package com.nlxa.java.usecase.product;

import com.nlxa.java.dto.product.request.AddProductRequest;
import com.nlxa.java.dto.product.request.DeleteProductByIdRequest;
import com.nlxa.java.dto.product.response.ProductResponse;
import com.nlxa.java.product.ProductBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteProductById {

    private ProductBusiness productBusiness;

    @Autowired
    public DeleteProductById(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    public boolean execute(DeleteProductByIdRequest request) {
        log.info("Call to: DeleteProductById.execute()");
        boolean response = false;
        try {
            response = this.productBusiness.deleteProductById(request);
        }catch (Exception e){
            log.error("Error in: DeleteProductById.execute()", e);
        }
        return response;
    }
}
