package com.nlxa.java.domain;

import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.request.UpdateClientRequest;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    public Client() {
    }

    public Client(AddClientRequest request) {
        this.clientId = request.getClientId();
        this.name = request.getName();
        this.password = request.getPassword();
        this.email = request.getEmail();
    }

    public Client(UpdateClientRequest request) {
        this.clientId = request.getClientId();
        this.name = request.getName();
        this.password = request.getPassword();
        this.email = request.getEmail();
    }
}
