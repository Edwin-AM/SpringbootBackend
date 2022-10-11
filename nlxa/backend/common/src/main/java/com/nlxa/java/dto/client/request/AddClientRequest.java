package com.nlxa.java.dto.client.request;

import com.nlxa.java.domain.Invoice;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AddClientRequest implements Serializable {
    private String name;
    private String lastName;
    private List<Invoice> invoiceList;

    public AddClientRequest() {
    }

    public AddClientRequest(String name, String lastName, List<Invoice> invoiceList) {
        this.name = name;
        this.lastName = lastName;
        this.invoiceList = invoiceList;
    }
}
