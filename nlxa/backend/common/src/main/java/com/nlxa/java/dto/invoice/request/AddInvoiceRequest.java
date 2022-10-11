package com.nlxa.java.dto.invoice.request;

import com.nlxa.java.domain.Client;
import com.nlxa.java.domain.Detail;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
public class AddInvoiceRequest implements Serializable {
    private String clientId;
    private String date;
    private Client client;
    private List<Detail> detailList;

    public AddInvoiceRequest() {
    }

    public AddInvoiceRequest(String clientId, String date, Client client, List<Detail> detailList) {
        this.clientId = clientId;
        this.date = date;
        this.client = client;
        this.detailList = detailList;
    }

}
