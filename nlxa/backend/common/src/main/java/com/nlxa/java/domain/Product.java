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
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(generator = "ID")
    @GenericGenerator(
            name = "ID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private float price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Detail detail;

    public Product() {

    }

    public Product(AddProductRequest request) {
        this.productId = request.getProductId();
        this.price = request.getPrice();
        this.productName = request.getProductName();
    }

    public Product(UpdateProductRequest request) {
        this.productId = request.getProductId();
        this.price = request.getPrice();
        this.productName = request.getProductName();
    }

}
