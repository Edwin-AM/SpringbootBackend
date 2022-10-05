package com.nlxa.java.usecase.invoice;

import com.nlxa.java.Invoice.InvoiceBusiness;
import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.response.ClientResponse;
import com.nlxa.java.dto.invoice.request.AddInvoiceRequest;
import com.nlxa.java.dto.invoice.response.InvoiceResponse;
import com.nlxa.java.exceptions.IncompleteDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class AddInvoice {

    private InvoiceBusiness invoiceBusiness;

    @Autowired
    public AddInvoice(InvoiceBusiness invoiceBusiness) {
        this.invoiceBusiness = invoiceBusiness;
    }

    /**
     * Tries up insert a new Invoice, validating its data
     *
     * @param request AddInvoiceRequest
     * @return Future<InvoiceResponse>
     * @throws IncompleteDataException
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    public Future<InvoiceResponse> execute(AddInvoiceRequest request) throws IncompleteDataException,
            IllegalArgumentException, NullPointerException {
        log.info("Call to: AddInvoice.execute()");
        AsyncResponse<InvoiceResponse> response = null;

        if (request == null) {
            throw new IllegalArgumentException("Null parameter in -> AddInvoice.execute()");
        }

        if (request.getInvoiceId().equalsIgnoreCase("") ||
                request.getClient() == null ||
                request.getClientId().equalsIgnoreCase("") ||
                request.getDate().equalsIgnoreCase("") ||
                request.getDetailList() == null

        ) {
            throw new IncompleteDataException("Missing data -> In AddInvoice.execute()");
        }
        response = new AsyncResponse<>(this.invoiceBusiness.addInvoice(request));
        return response;
    }
}
