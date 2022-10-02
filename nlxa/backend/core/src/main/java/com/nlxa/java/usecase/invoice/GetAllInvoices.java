package com.nlxa.java.usecase.invoice;

import com.nlxa.java.Invoice.InvoiceBusiness;
import com.nlxa.java.dto.invoice.response.InvoiceListResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GetAllInvoices {

    private InvoiceBusiness invoiceBusiness;

    @Autowired
    public GetAllInvoices(InvoiceBusiness invoiceBusiness) {
        this.invoiceBusiness = invoiceBusiness;
    }

    public InvoiceListResponse execute(){
        InvoiceListResponse invoiceListResponse = null;

        try {
            invoiceListResponse = this.invoiceBusiness.getAllInvoices();
        } catch (Exception ex) {
            log.error("Error in: GetAllInvoices.execute()", ex);
        }

        return invoiceListResponse;
    }
}
