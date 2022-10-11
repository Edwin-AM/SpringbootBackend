package com.nlxa.java.usecase.product;

import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.product.request.AddProductRequest;
import com.nlxa.java.dto.product.request.DeleteProductByIdRequest;
import com.nlxa.java.dto.product.response.ProductDeleteResponse;
import com.nlxa.java.dto.product.response.ProductResponse;
import com.nlxa.java.error.RequestException;
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
     */
    public Future<ProductDeleteResponse> execute(DeleteProductByIdRequest request) throws RequestException {
        log.info("Call to: DeleteProductById.execute()");
        AsyncResponse<ProductDeleteResponse> response = null;

        try {
            if (request.getProductId().equalsIgnoreCase("")) {
                throw new RequestException("Error in DeleteProductById.execute", "Incomplete data");
            }
        } catch (RequestException e) {
            log.error("Error in DeleteProductById.execute -> "+ e.getMessage());
        }

        response = new AsyncResponse<>(this.productBusiness.deleteProductById(request));
        return response;
    }
}
