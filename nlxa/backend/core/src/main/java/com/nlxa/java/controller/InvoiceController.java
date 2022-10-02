package com.nlxa.java.controller;

import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.response.ClientResponse;
import com.nlxa.java.dto.invoice.request.AddInvoiceRequest;
import com.nlxa.java.dto.invoice.response.InvoiceListResponse;
import com.nlxa.java.dto.invoice.response.InvoiceResponse;
import com.nlxa.java.usecase.invoice.AddInvoice;
import com.nlxa.java.usecase.invoice.GetAllInvoices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

    private GetAllInvoices getAllInvoices;
    private AddInvoice addInvoice;

    public InvoiceController(GetAllInvoices getAllInvoices, AddInvoice addInvoice) {
        this.getAllInvoices = getAllInvoices;
        this.addInvoice = addInvoice;
    }

    @GetMapping(value = "all")
    public InvoiceListResponse getAllInvoices() {
        log.info("Call to: InvoiceController.getAllInvoicess()");
        InvoiceListResponse invoiceListResponse = null;

        try {
            invoiceListResponse = this.getAllInvoices.execute();
        } catch (Exception ex) {
            log.error("Error in: InvoiceController.getAllInvoices()", ex);
        }

        return invoiceListResponse;
    }

    @PostMapping(value = "/add")
    public InvoiceResponse addInvoice(@RequestBody AddInvoiceRequest request) {
        log.info("Call to: InvoiceController.addInvoice()");
        InvoiceResponse response = null;

        try {
            response = this.addInvoice.execute(request);
        }catch (Exception e){
            log.error("Error in: InvoiceController.addInvoice()", e);
        }
        return response;
    }
}
