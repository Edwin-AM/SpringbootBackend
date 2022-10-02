package com.nlxa.java.usecase.client;

import com.nlxa.java.client.ClientBusiness;
import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.request.UpdateClientRequest;
import com.nlxa.java.dto.client.response.ClientResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UpdateClient {

    private ClientBusiness clientBusiness;

    @Autowired
    public UpdateClient(ClientBusiness clientBusiness) {
        this.clientBusiness = clientBusiness;
    }

    public ClientResponse execute(UpdateClientRequest request) {
        log.info("Call to: UpdateClient.execute()");
        ClientResponse response = null;
        try {
            response = this.clientBusiness.updateClient(request);
        }catch (Exception e){
            log.error("Error in: UpdateClient.execute()", e);
        }
        return response;
    }
}
