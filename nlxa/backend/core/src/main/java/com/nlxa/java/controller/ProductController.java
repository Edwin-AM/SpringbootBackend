package com.nlxa.java.controller;

import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.response.ClientResponse;
import com.nlxa.java.dto.product.request.AddProductRequest;
import com.nlxa.java.dto.product.request.DeleteProductByIdRequest;
import com.nlxa.java.dto.product.request.UpdateProductRequest;
import com.nlxa.java.dto.product.response.ProductDeleteResponse;
import com.nlxa.java.dto.product.response.ProductListResponse;
import com.nlxa.java.dto.product.response.ProductResponse;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.exceptions.IncompleteDataException;
import com.nlxa.java.usecase.product.AddProduct;
import com.nlxa.java.usecase.product.DeleteProductById;
import com.nlxa.java.usecase.product.GetAllProducts;
import com.nlxa.java.usecase.product.UpdateProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    /**
     * Return a list of Products
     *
     * @return ResponseEntity<Future<ProductListResponse>>
     */
    @GetMapping(value = "all")
    public ResponseEntity<ProductListResponse> getAllProducts(){
        log.info("Call to: ProductController.getAllProducts()");
        Future<ProductListResponse> result = null;
        ProductListResponse response = null;
        try {
            result = this.getAllProducts.execute();
            response = result.get();
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (RequestException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } finally {
            log.info("[+] Response values in ProductController.getAllProducts: " + response.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Insert a new Product
     *
     * @param request AddProductRequest
     * @return ResponseEntity<Future<ProductResponse>>
     */
    @PostMapping(value = "/add")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody AddProductRequest request) {
        log.info("Call to: ProductController.addProduct()");
        Future<ProductResponse> result = null;
        ProductResponse response = null;

        try {
            result = this.addProduct.execute(request);
            response = result.get();
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (RequestException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } finally {
            log.info("[+] Request values in ProductController.addProduct: " + request.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Update a Product
     *
     * @param request UpdateProductRequest
     * @return ResponseEntity<Future<ProductResponse>>
     */
    @PutMapping(value = "/update")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody UpdateProductRequest request) {
        log.info("Call to: ProductController.updateProduct()");
        Future<ProductResponse> result = null;
        ProductResponse response = null;

        try {
            result = this.updateProduct.execute(request);
            response = result.get();
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (RequestException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } finally {
            log.info("[+] Request values in ProductController.updateProduct: " + request.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Delete a Product given an id
     *
     * @param request DeleteProductByIdRequest
     * @return ResponseEntity<Future<ProductDeleteResponse>>
     */
    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<ProductDeleteResponse> deleteById(@RequestBody DeleteProductByIdRequest request) {
        log.info("Call to: ProductController.deleteById()");
        Future<ProductDeleteResponse> result = null;
        ProductDeleteResponse response = null;

        try {
            result = this.deleteProductById.execute(request);
            response = result.get();
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (RequestException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } finally {
            log.info("[+] Request values in ProductController.deleteById: " + request.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
