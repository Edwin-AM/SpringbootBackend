package com.nlxa.java.dto.invoice.response;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class InvoiceListResponse implements Serializable {

    private List<InvoiceResponse> invoiceResponseList;

    public InvoiceListResponse() {
        this.invoiceResponseList = new ArrayList<>();
    }

    public InvoiceListResponse(List<InvoiceResponse> invoiceResponseList) {
        this.invoiceResponseList = invoiceResponseList;
    }
}
