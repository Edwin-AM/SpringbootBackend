package com.nlxa.java.usecase.invoice;

import com.nlxa.java.Invoice.InvoiceBusiness;
import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.invoice.response.InvoiceListResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class GetAllInvoices {

    private InvoiceBusiness invoiceBusiness;

    @Autowired
    public GetAllInvoices(InvoiceBusiness invoiceBusiness) {
        this.invoiceBusiness = invoiceBusiness;
    }

    /**
     * Tries to return a list of Invoice
     *
     * @return Future<InvoiceListResponse>
     */
    public Future<InvoiceListResponse> execute(){
        AsyncResponse<InvoiceListResponse> response = null;

        try {
            response = new AsyncResponse<>(this.invoiceBusiness.getAllInvoices());
        } catch (Exception e) {
            log.error("Error in GetAllInvoices.execute");
        }

        return response;
    }
}
