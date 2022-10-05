package com.nlxa.java.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "detail")
public class Detail {
    @Id
    @Column(name = "detail_id")
    @GeneratedValue(generator = "ID")
    @GenericGenerator(
            name = "ID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String detailId;

    @Column(name = "item_amount")
    private int itemAmount;

    @Column(name = "price")
    private float price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @OneToMany(mappedBy = "detail")
    private List<Product> productList;


}
