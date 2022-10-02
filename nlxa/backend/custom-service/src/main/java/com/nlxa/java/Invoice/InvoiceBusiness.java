package com.nlxa.java.Invoice;

import com.nlxa.java.domain.Invoice;
import com.nlxa.java.domain.Product;
import com.nlxa.java.dto.invoice.request.AddInvoiceRequest;
import com.nlxa.java.dto.invoice.response.InvoiceListResponse;
import com.nlxa.java.dto.invoice.response.InvoiceResponse;
import com.nlxa.java.dto.product.request.AddProductRequest;
import com.nlxa.java.dto.product.response.ProductResponse;
import com.nlxa.java.jpa.InvoiceJPAComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class InvoiceBusiness {

    private InvoiceJPAComponent invoiceJPAComponent;

    @Autowired
    public InvoiceBusiness(InvoiceJPAComponent invoiceJPAComponent) {
        this.invoiceJPAComponent = invoiceJPAComponent;
    }

    public InvoiceListResponse getAllInvoices() {
        log.info("Call to: InvoiceBusiness.getAllInvoices()");

        InvoiceListResponse invoiceListResponse = null;

        try {
            invoiceListResponse = new InvoiceListResponse();
            List<Invoice> invoices = this.invoiceJPAComponent.getAll();
            for (Invoice invoice: invoices) {
                invoiceListResponse.getInvoiceResponseList().add(new InvoiceResponse(invoice));
            }
        } catch (Exception ex) {
            log.error("Error in: InvoiceBusiness.getAllInvoices() -> Verify that the connection is correct");
        }

        return invoiceListResponse;
    }

    public InvoiceResponse addInvoice(AddInvoiceRequest request) {
        log.info("Call to: InvoiceBusiness.addInvoice()");
        InvoiceResponse invoiceResponse = null;

        try {
            invoiceResponse = new InvoiceResponse(this.invoiceJPAComponent.save(new Invoice(request)));
        } catch (Exception e){
            log.info("Error in: ProductBusiness.addInvoice()", e);
        }

        return invoiceResponse;
    }
}
