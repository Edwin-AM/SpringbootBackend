package com.nlxa.java.domain;

import com.nlxa.java.dto.invoice.request.AddInvoiceRequest;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "invoice")
public class Invoice implements Serializable{
    @Id
    @Column(name = "invoice_id")
    @GeneratedValue(generator = "ID")
    @GenericGenerator(
            name = "ID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String invoiceId;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;

    @OneToMany(mappedBy = "invoice")
    private List<Detail> detailList;

    public Invoice() {
        this.invoiceId = "";
        this.clientId = "";
        this.client = new Client();
        this.date = "";
        this.detailList = new ArrayList<>();
    }

    public Invoice(AddInvoiceRequest request) {
        this.invoiceId = request.getInvoiceId();
    }
}
