package com.nlxa.java.usecase.invoice;

import com.nlxa.java.Invoice.InvoiceBusiness;
import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.response.ClientResponse;
import com.nlxa.java.dto.invoice.request.AddInvoiceRequest;
import com.nlxa.java.dto.invoice.response.InvoiceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AddInvoice {

    private InvoiceBusiness invoiceBusiness;

    @Autowired
    public AddInvoice(InvoiceBusiness invoiceBusiness) {
        this.invoiceBusiness = invoiceBusiness;
    }

    public InvoiceResponse execute(AddInvoiceRequest request) {
        log.info("Call to: AddInvoice.execute()");
        InvoiceResponse response = null;
        try {
            response = this.invoiceBusiness.addInvoice(request);
        }catch (Exception e){
            log.error("Error in: AddInvoice.execute()", e);
        }
        return response;
    }
}
