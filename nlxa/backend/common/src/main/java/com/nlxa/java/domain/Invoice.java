package com.nlxa.java.domain;

import com.nlxa.java.dto.invoice.request.AddInvoiceRequest;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

    @Id
    @Column(name = "invoice_id")
    @GeneratedValue(generator = "ID")
    @GenericGenerator(
            name = "ID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String invoiceId;

    @Column(name = "description")
    private String description;

    public Invoice() {
    }

    public Invoice(AddInvoiceRequest request) {
        this.invoiceId = request.getInvoiceId();
        this.description = request.getDescription();
    }
}
