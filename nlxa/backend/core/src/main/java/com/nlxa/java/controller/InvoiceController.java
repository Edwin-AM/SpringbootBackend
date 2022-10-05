package com.nlxa.java.controller;

import com.nlxa.java.dto.invoice.request.AddInvoiceRequest;
import com.nlxa.java.dto.invoice.response.InvoiceListResponse;
import com.nlxa.java.dto.invoice.response.InvoiceResponse;
import com.nlxa.java.exceptions.IncompleteDataException;
import com.nlxa.java.usecase.invoice.AddInvoice;
import com.nlxa.java.usecase.invoice.GetAllInvoices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Future;

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

    /**
     * Return a list of Invoices
     *
     * @return ResponseEntity<Future<InvoiceListResponse>>
     */
    @GetMapping(value = "/all")
    public ResponseEntity<Future<InvoiceListResponse>> getAllInvoices() {
        log.info("Call to: InvoiceController.getAllInvoicess()");
        Future<InvoiceListResponse> response = null;

        try {
            response = this.getAllInvoices.execute();
        } catch (IncompleteDataException ie) {
            log.error("Error in: InvoiceController.getAllInvoices() | IncompleteDataException | " + ie.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e){
            log.error("Error in: InvoiceController.getAllInvoices() | IllegalArgumentException | " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (NullPointerException eo) {
            log.error("Error in: InvoiceController.getAllInvoices() | NullPointerException | " + eo.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } finally {
            log.info("[+] Response values in InvoiceController.getAllInvoices: " + response.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Insert a new Invoice
     *
     * @param request AddInvoiceRequest
     * @return ResponseEntity<Future<InvoiceResponse>>
     */
    @PostMapping(value = "/add")
    public ResponseEntity<Future<InvoiceResponse>> addInvoice(@RequestBody AddInvoiceRequest request) {
        log.info("Call to: InvoiceController.addInvoice()");
        Future<InvoiceResponse> response = null;

        try {
            response = this.addInvoice.execute(request);
        } catch (IncompleteDataException ie) {
            log.error("Error in: InvoiceController.addInvoice() | IncompleteDataException | " + ie.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e){
            log.error("Error in: InvoiceController.addInvoice() | IllegalArgumentException | " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (NullPointerException eo) {
            log.error("Error in: InvoiceController.addInvoice() | NullPointerException | " + eo.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } finally {
            log.info("[+] Request values in InvoiceController.addInvoice: " + request.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
