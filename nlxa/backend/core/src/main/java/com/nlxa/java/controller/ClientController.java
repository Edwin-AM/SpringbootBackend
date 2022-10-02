package com.nlxa.java.controller;

import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.request.UpdateClientRequest;
import com.nlxa.java.dto.client.response.ClientResponse;
import com.nlxa.java.usecase.client.AddClient;
import com.nlxa.java.usecase.client.UpdateClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/client")
public class ClientController {

    private AddClient addClient;
    private UpdateClient updateClient;

    @Autowired
    public ClientController(AddClient addClient, UpdateClient updateClient) {
        this.addClient = addClient;
        this.updateClient = updateClient;
    }

    @PostMapping(value = "/add")
    public ClientResponse addClient(@RequestBody AddClientRequest request) {
        log.info("Call to: ClientController.addClient()");
        ClientResponse response = null;

        try {
            response = this.addClient.execute(request);
        }catch (Exception e){
            log.error("Error in: ClientController.addClient()",e);
        }
        return response;
    }

    @PutMapping(value = "/put")
    public ClientResponse updateClient(@RequestBody UpdateClientRequest request) {
        log.info("Call to: ClientController.updateClient()");
        ClientResponse response = null;

        try {
            response = this.updateClient.execute(request);
        }catch (Exception e){
            log.error("Error in: ClientController.updateClient()",e);
        }
        return response;
    }
}
