package com.nlxa.java.dto.invoice.response;

import com.nlxa.java.domain.Invoice;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class InvoiceResponse implements Serializable {

    private String invoiceId;
    private String clientId;

    public InvoiceResponse(Invoice invoice) {
        this.invoiceId = invoice.getInvoiceId();
        this.clientId = invoice.getClientId();
    }
}
