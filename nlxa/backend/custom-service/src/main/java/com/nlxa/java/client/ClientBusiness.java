package com.nlxa.java.client;

import com.nlxa.java.domain.Client;
import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.request.DeleteClientRequest;
import com.nlxa.java.dto.client.request.GetClientByIdRequest;
import com.nlxa.java.dto.client.request.UpdateClientRequest;
import com.nlxa.java.dto.client.response.ClientDeleteResponse;
import com.nlxa.java.dto.client.response.ClientResponse;
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

    /**
     * Tries to insert a Client
     *
     * @param request AddClientRequest
     * @return ClientResponse
     */
    public ClientResponse addClient(AddClientRequest request) {
        log.info("Call to: ClientBusiness.addClient()");
        ClientResponse clientResponse = null;

        try {
            clientResponse = new ClientResponse(this.clientJPAComponent.save(new Client(request)));
        } catch (Exception e) {
            log.error("Error in ClientBusiness.addClient -> " + e.getMessage());
        }

        return clientResponse;
    }

    /**
     * Tries to update a Client
     *
     * @param request UpdateClientRequest
     * @return ClientResponse
     */
    public ClientResponse updateClient(UpdateClientRequest request) {
        log.info("Call to: ClientBusiness.updateClient()");
        ClientResponse response = null;

        try {
            response = new ClientResponse(this.clientJPAComponent.update(new Client(request)));
        } catch (Exception e) {
            log.error("Error in ClientBusiness.updateClient -> " + e.getMessage());
        }

        return response;
    }

    /**
     * Tries to delete a Client given an id
     *
     * @param request DeleteClientRequest
     * @return ClientDeleteResponse
     */
    public ClientDeleteResponse deleteClientById(DeleteClientRequest request) {
        log.info("Call to: ClientBusiness.deleteClientById()");

        ClientDeleteResponse response = new ClientDeleteResponse(false);

        try {
            this.clientJPAComponent.deleteById(request.getClientId());
            response.setResult(true);
        } catch (Exception e) {
            log.error("Error in ClientBusiness.deleteClientById -> " + e.getMessage());
        }

        return response;
    }

    public ClientResponse getClientById(GetClientByIdRequest request) {
        log.info("Call to: ClientBusiness.deleteClientById()");
        ClientResponse response = null;

        try {
            Client client  = this.clientJPAComponent.getById(request.getClientId());
            response = new ClientResponse(client);
        } catch (Exception e) {
            log.error("Error in ClientBusiness.getClientById -> " + e.getMessage());
        }

        return response;
    }
}
