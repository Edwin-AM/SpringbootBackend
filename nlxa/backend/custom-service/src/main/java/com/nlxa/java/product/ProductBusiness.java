package com.nlxa.java.product;

import com.nlxa.java.domain.Product;
import com.nlxa.java.dto.product.request.AddProductRequest;
import com.nlxa.java.dto.product.request.DeleteProductByIdRequest;
import com.nlxa.java.dto.product.request.UpdateProductRequest;
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

    public ProductListResponse getAllProducts() {
        log.info("Call to: ProductBusiness.getAllProducts()");
        ProductListResponse productListResponse = null;

        try {
            productListResponse = new ProductListResponse();
            List<Product> products = this.productJPAComponent.getAll();

            for (Product product: products) {
                productListResponse.getProductResponseList().add(new ProductResponse(product));
            }
        } catch (Exception ex) {
            log.error("Error in: ProductBusiness.getAllProducts() -> Verify that the connection is correct");
        }

        return productListResponse;
    }

    public ProductResponse addProduct(AddProductRequest request) {
        log.info("Call to: ProductBusiness.addProduct()");
        ProductResponse productResponse = null;

        try {
            productResponse = new ProductResponse(this.productJPAComponent.save(new Product(request)));
        } catch (Exception e){
            log.info("Error in: ProductBusiness.addProduct()", e);
        }

        return productResponse;
    }

    public ProductResponse updateProduct(UpdateProductRequest request) {
        log.info("Call to: ProductBusiness.updateProduct()");
        ProductResponse productResponse = null;

        try {
            productResponse = new ProductResponse(this.productJPAComponent.update(new Product(request)));
        } catch (Exception e){
            log.info("Error in: ProductBusiness.updateProduct()", e);
        }

        return productResponse;
    }

    public boolean deleteProductById(DeleteProductByIdRequest request) {
        log.info("Call to: ProductBusiness.deleteProduct()");
        boolean response = false;
        try{
            this.productJPAComponent.deleteById(request.getProductId());
            response = true;
        } catch (Exception e){
            log.info("Error in: LevelBusiness.deleteLevel()",e);
        }
        return response;
    }
}
