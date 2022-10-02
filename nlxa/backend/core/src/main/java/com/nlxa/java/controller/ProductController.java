package com.nlxa.java.controller;

import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.response.ClientResponse;
import com.nlxa.java.dto.product.request.AddProductRequest;
import com.nlxa.java.dto.product.request.DeleteProductByIdRequest;
import com.nlxa.java.dto.product.request.UpdateProductRequest;
import com.nlxa.java.dto.product.response.ProductListResponse;
import com.nlxa.java.dto.product.response.ProductResponse;
import com.nlxa.java.usecase.product.AddProduct;
import com.nlxa.java.usecase.product.DeleteProductById;
import com.nlxa.java.usecase.product.GetAllProducts;
import com.nlxa.java.usecase.product.UpdateProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private GetAllProducts getAllProducts;
    private AddProduct addProduct;
    private UpdateProduct updateProduct;
    private DeleteProductById deleteProductById;

    public ProductController(GetAllProducts getAllProducts,
                             AddProduct addProduct,
                             UpdateProduct updateProduct,
                             DeleteProductById deleteProductById) {
        this.getAllProducts = getAllProducts;
        this.addProduct = addProduct;
        this.updateProduct = updateProduct;
        this.deleteProductById = deleteProductById;
    }

    @GetMapping(value = "all")
    public ProductListResponse getAllProducts(){
        log.info("Call to: ProductController.getAllProducts()");
        ProductListResponse productListResponse = null;

        try {
            productListResponse = this.getAllProducts.execute();
        } catch (Exception ex) {
            log.error("Error in: ProductController.getAllProducts()", ex);
        }

        return productListResponse;
    }

    @PostMapping(value = "/add")
    public ProductResponse addProduct(@RequestBody AddProductRequest request) {
        log.info("Call to: ProductController.addProduct()");
        ProductResponse response = null;

        try {
            response = this.addProduct.execute(request);
        }catch (Exception e){
            log.error("Error in: ProductController.addProduct()",e);
        }
        return response;
    }

    @PutMapping(value = "/add")
    public ProductResponse updateProduct(@RequestBody UpdateProductRequest request) {
        log.info("Call to: ProductController.updateProduct()");
        ProductResponse response = null;

        try {
            response = this.updateProduct.execute(request);
        }catch (Exception e){
            log.error("Error in: ProductController.updateProduct()",e);
        }
        return response;
    }

    @DeleteMapping(value = "/deleteById")
    public boolean deleteById(@RequestBody DeleteProductByIdRequest request) {
        log.info("Call to: ProductController.deleteById()");
        boolean response = false;

        try {
            response = this.deleteProductById.execute(request);
        }catch (Exception e){
            log.error("Error in: ProductController.deleteById()",e);
        }
        return response;
    }
}
