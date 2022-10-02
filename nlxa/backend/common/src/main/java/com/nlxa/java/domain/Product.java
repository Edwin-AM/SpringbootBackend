package com.nlxa.java.domain;

import com.nlxa.java.dto.product.request.AddProductRequest;
import com.nlxa.java.dto.product.request.UpdateProductRequest;
import com.nlxa.java.dto.product.response.ProductResponse;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(generator = "ID")
    @GenericGenerator(
            name = "ID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String productId;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private float price;

    public Product() {

    }

    public Product(AddProductRequest request) {
        this.productId = request.getProductId();
        this.description = request.getDescription();
        this.price = request.getPrice();
    }

    public Product(UpdateProductRequest request) {
        this.productId = request.getProductId();
        this.description = request.getDescription();
        this.price = request.getPrice();
    }

}
