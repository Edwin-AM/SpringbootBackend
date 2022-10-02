package com.nlxa.java.client;

import com.nlxa.java.domain.Client;
import com.nlxa.java.domain.Product;
import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.request.UpdateClientRequest;
import com.nlxa.java.dto.client.response.ClientResponse;
import com.nlxa.java.dto.product.request.UpdateProductRequest;
import com.nlxa.java.dto.product.response.ProductResponse;
import com.nlxa.java.jpa.ClientJPAComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClientBusiness {

    private ClientJPAComponent clientJPAComponent;

    @Autowired
    public ClientBusiness(ClientJPAComponent clientJPAComponent) {
        this.clientJPAComponent = clientJPAComponent;
    }

    public ClientResponse addClient(AddClientRequest request) {
        log.info("Call to: ClientBusiness.addClient()");
        ClientResponse clientResponse = null;

        try{
            clientResponse = new ClientResponse(this.clientJPAComponent.save(new Client(request)));
        } catch (Exception e){
            log.info("Error in: ClientBusiness.addClient()", e);
        }

        return clientResponse;
    }

    public ClientResponse updateClient(UpdateClientRequest request) {
        log.info("Call to: ClientBusiness.updateClient()");
        ClientResponse response = null;

        try {
            response = new ClientResponse(this.clientJPAComponent.update(new Client(request)));
        } catch (Exception e){
            log.info("Error in: ClientBusiness.updateClient()", e);
        }

        return response;
    }
}
