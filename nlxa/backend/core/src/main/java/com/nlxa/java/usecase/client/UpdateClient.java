package com.nlxa.java.usecase.client;

import com.nlxa.java.client.ClientBusiness;
import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.request.UpdateClientRequest;
import com.nlxa.java.dto.client.response.ClientResponse;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.exceptions.IncompleteDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class UpdateClient {

    private ClientBusiness clientBusiness;

    @Autowired
    public UpdateClient(ClientBusiness clientBusiness) {
        this.clientBusiness = clientBusiness;
    }

    /**
     * Tries to update a client, validating its data
     *
     * @param request UpdateClientRequest
     * @return Future<ClientResponse>
     * @throws RequestException
     */
    public Future<ClientResponse> execute(UpdateClientRequest request) throws RequestException {
        log.info("Call to: UpdateClient.execute()");
        AsyncResponse<ClientResponse> response = null;

        try {
            if (request.getClientId().equalsIgnoreCase("") ||
                    request.getName().equalsIgnoreCase("") ||
                    request.getLastName().equalsIgnoreCase("")
            ) {
                throw new RequestException("Error in Update.execute", "Incomplete data");
            }
        } catch (RequestException e) {
            log.error("Error in Update.execute -> "+ e.getMessage());
        }

        response = new AsyncResponse<>(this.clientBusiness.updateClient(request));

        return response;
    }
}
