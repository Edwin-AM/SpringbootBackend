package com.nlxa.java.domain;

import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.request.UpdateClientRequest;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Client")
public class Client {
    @Id
    @Column(name = "client_id")
    @GeneratedValue(generator = "ID")
    @GenericGenerator(
            name = "ID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String clientId;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @OneToMany(mappedBy = "client")
    private List<Invoice> invoiceList;

    public Client() {
        this.clientId = "";
        this.name = "";
        this.lastName = "";
        this.invoiceList = new ArrayList<>();
    }

    public Client(AddClientRequest request) {
        this.name = request.getName();
        this.lastName = request.getLastName();
        this.invoiceList = request.getInvoiceList();
    }

    public Client(UpdateClientRequest request) {
        this.clientId = request.getClientId();
        this.name = request.getName();
        this.lastName = request.getLastName();
    }
}
