package com.nlxa.java.dto.invoice.request;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class AddInvoiceRequest implements Serializable {

    private String invoiceId;
    private String description;

    public AddInvoiceRequest(String invoiceId, String description) {
        this.invoiceId = invoiceId;
        this.description = description;
    }
}
