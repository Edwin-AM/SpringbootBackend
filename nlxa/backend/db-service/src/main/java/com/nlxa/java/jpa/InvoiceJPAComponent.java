package com.nlxa.java.jpa;

import com.nlxa.java.domain.Invoice;
import com.nlxa.java.domain.Product;
import com.nlxa.java.impl.InvoiceImpl;
import com.nlxa.java.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class InvoiceJPAComponent implements InvoiceImpl {

    private InvoiceRepository invoiceRepository;

    public InvoiceJPAComponent(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> getAll() {
        log.info("Call to: ProductJPAComponent.getAll()");
        List<Invoice> response = null;

        try {
            response = this.invoiceRepository.findAll();
        } catch (Exception e){
            log.error("Error in: InvoiceJPAComponent.getAll() -> "+ e.getMessage(), e);
        }

        return response;
    }

    @Override
    public Invoice getById(String s) {
        return null;
    }

    @Override
    public Invoice save(Invoice type) {
        log.info("Call to: InvoiceJPAComponent.save()");
        Invoice response = null;

        try {
            response = this.invoiceRepository.save(type);
        } catch (Exception e){
            log.error("Error in: InvoiceJPAComponent.save() -> "+ e.getMessage(), e);
        }

        return response;
    }

    @Override
    public Invoice update(Invoice type) {
        return null;
    }

    @Override
    public void delete(Invoice type) {

    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public Boolean verifyValueID(String id) {
        return null;
    }
}
