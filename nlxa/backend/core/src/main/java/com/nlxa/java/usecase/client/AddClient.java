package com.nlxa.java.usecase.client;

import com.nlxa.java.client.ClientBusiness;
import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.response.ClientResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AddClient {

    private ClientBusiness clientBusiness;

    @Autowired
    public AddClient(ClientBusiness clientBusiness) {
        this.clientBusiness = clientBusiness;
    }

    public ClientResponse execute(AddClientRequest request) {
        log.info("Call to: AddClient.execute()");
        ClientResponse response = null;
        try {
            response = this.clientBusiness.addClient(request);
        }catch (Exception e){
            log.error("Error in: AddClient.execute()", e);
        }
        return response;
    }
}
