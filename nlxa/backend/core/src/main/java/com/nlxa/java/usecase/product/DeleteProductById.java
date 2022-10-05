package com.nlxa.java.usecase.product;

import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.product.request.AddProductRequest;
import com.nlxa.java.dto.product.request.DeleteProductByIdRequest;
import com.nlxa.java.dto.product.response.ProductDeleteResponse;
import com.nlxa.java.dto.product.response.ProductResponse;
import com.nlxa.java.exceptions.IncompleteDataException;
import com.nlxa.java.product.ProductBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class DeleteProductById {

    private ProductBusiness productBusiness;

    @Autowired
    public DeleteProductById(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    /**
     * Tries to delete a Product given an id, validating its data.
     *
     * @param request DeleteProductByIdRequest
     * @return Future<ProductDeleteResponse>
     * @throws IncompleteDataException
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    public Future<ProductDeleteResponse> execute(DeleteProductByIdRequest request) throws IncompleteDataException,
            IllegalArgumentException, NullPointerException {
        log.info("Call to: DeleteProductById.execute()");
        AsyncResponse<ProductDeleteResponse> response = null;

        if (request == null) {
            throw new IllegalArgumentException("Null parameter in -> DeleteProductById.execute()");
        }

        if (request.getProductId().equalsIgnoreCase("")) {
            throw new IncompleteDataException("Missing data -> In DeleteProductById.execute()");
        }
        response = new AsyncResponse<>(this.productBusiness.deleteProductById(request));
        return response;
    }
}
