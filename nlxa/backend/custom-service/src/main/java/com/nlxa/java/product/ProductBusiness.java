package com.nlxa.java.product;

import com.nlxa.java.domain.Product;
import com.nlxa.java.dto.product.request.AddProductRequest;
import com.nlxa.java.dto.product.request.DeleteProductByIdRequest;
import com.nlxa.java.dto.product.request.UpdateProductRequest;
import com.nlxa.java.dto.product.response.ProductDeleteResponse;
import com.nlxa.java.dto.product.response.ProductListResponse;
import com.nlxa.java.dto.product.response.ProductResponse;
import com.nlxa.java.jpa.ProductJPAComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductBusiness {

    private ProductJPAComponent productJPAComponent;

    @Autowired
    public ProductBusiness(ProductJPAComponent productJPAComponent) {
        this.productJPAComponent = productJPAComponent;
    }

    /**
     * Tries to return a list of Product
     *
     * @return ProductListResponse
     */
    public ProductListResponse getAllProducts() {
        log.info("Call to: ProductBusiness.getAllProducts()");
        ProductListResponse productListResponse = null;

        productListResponse = new ProductListResponse();
        List<Product> products = this.productJPAComponent.getAll();

        for (Product product: products) {
            productListResponse.getProductResponseList().add(new ProductResponse(product));
        }

        return productListResponse;
    }

    /**
     * Tries to insert a Product
     *
     * @param request AddProductRequest
     * @return ProductResponse
     */
    public ProductResponse addProduct(AddProductRequest request) {
        log.info("Call to: ProductBusiness.addProduct()");
        ProductResponse productResponse = null;

        productResponse = new ProductResponse(this.productJPAComponent.save(new Product(request)));

        return productResponse;
    }

    /**
     * Tries to update a Product
     *
     * @param request UpdateProductRequest
     * @return ProductResponse
     */
    public ProductResponse updateProduct(UpdateProductRequest request) {
        log.info("Call to: ProductBusiness.updateProduct()");
        ProductResponse productResponse = null;

        productResponse = new ProductResponse(this.productJPAComponent.update(new Product(request)));

        return productResponse;
    }

    /**
     * Tries to delete a Product given an id
     *
     * @param request DeleteProductByIdRequest
     * @return ProductDeleteResponse
     */
    public ProductDeleteResponse deleteProductById(DeleteProductByIdRequest request) {
        log.info("Call to: ProductBusiness.deleteProduct()");
        ProductDeleteResponse response = new ProductDeleteResponse(false);

        this.productJPAComponent.deleteById(request.getProductId());
        response.setResult(true);

        return response;
    }
}
