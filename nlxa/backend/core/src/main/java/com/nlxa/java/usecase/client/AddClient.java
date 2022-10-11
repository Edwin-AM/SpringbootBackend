package com.nlxa.java.usecase.client;

import com.nlxa.java.client.ClientBusiness;
import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.response.ClientResponse;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.exceptions.IncompleteDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class AddClient {

    private ClientBusiness clientBusiness;

    @Autowired
    public AddClient(ClientBusiness clientBusiness) {
        this.clientBusiness = clientBusiness;
    }

    /**
     * Tries to insert a client, validating its data
     *
     * @param request AddClientRequest
     * @return Future<ClientResponse>
     * @throws RequestException
     */
    public Future<ClientResponse> execute(AddClientRequest request) throws RequestException {
        log.info("Call to: AddClient.execute()");
        AsyncResponse<ClientResponse> response = null;

        try {
            if (request.getName().equalsIgnoreCase("") ||
                    request.getLastName().equalsIgnoreCase("") ||
                    request.getInvoiceList() == null
            ) {
                throw new RequestException("Error in AddClient.execute", "Incomplete data");
            }
        } catch (RequestException e) {
            log.error("Error in AddClient.execute -> "+ e.getMessage());
        }

        response = new AsyncResponse<>(this.clientBusiness.addClient(request));
        return response;
    }
}
