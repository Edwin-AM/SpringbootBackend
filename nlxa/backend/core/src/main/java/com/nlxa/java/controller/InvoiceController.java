package com.nlxa.java.controller;

import com.nlxa.java.dto.invoice.request.AddInvoiceRequest;
import com.nlxa.java.dto.invoice.response.InvoiceListResponse;
import com.nlxa.java.dto.invoice.response.InvoiceResponse;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.exceptions.IncompleteDataException;
import com.nlxa.java.usecase.invoice.AddInvoice;
import com.nlxa.java.usecase.invoice.GetAllInvoices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
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
     * @return ResponseEntity<InvoiceListResponse>
     */
    @GetMapping(value = "/all")
    public ResponseEntity<InvoiceListResponse> getAllInvoices() {
        log.info("Call to: InvoiceController.getAllInvoicess()");

        Future<InvoiceListResponse> result = null;
        InvoiceListResponse response = null;
        try {
            result = this.getAllInvoices.execute();
            response = result.get();
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (RequestException e) {
            log.error(e.getMessage());
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
     * @return ResponseEntity<InvoiceResponse>
     */
    @PostMapping(value = "/add")
    public ResponseEntity<InvoiceResponse> addInvoice(@RequestBody AddInvoiceRequest request) {
        log.info("Call to: InvoiceController.addInvoice()");
        Future<InvoiceResponse> result = null;
        InvoiceResponse response = null;
        try {
            result = this.addInvoice.execute(request);
            response = result.get();
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (RequestException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } finally {
            log.info("[+] Response values in InvoiceController.addInvoice: " + request.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
