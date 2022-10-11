package com.nlxa.java.usecase.client;

import com.nlxa.java.client.ClientBusiness;
import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.request.GetClientByIdRequest;
import com.nlxa.java.dto.client.response.ClientResponse;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.exceptions.IncompleteDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class GetClientById {

    private ClientBusiness clientBusiness;

    @Autowired
    public GetClientById(ClientBusiness clientBusiness) {
        this.clientBusiness = clientBusiness;
    }

    /**
     * Tries to get a client given an id, validating its data
     *
     * @param request GetClientByIdRequest
     * @return Future<ClientResponse>
     * @throws IncompleteDataException
     */
    public Future<ClientResponse> execute(GetClientByIdRequest request) throws RequestException {
        log.info("Call to: GetClientById.execute()");
        AsyncResponse<ClientResponse> response = null;

        try {
            if (request.getClientId().equalsIgnoreCase("")) {
                throw new RequestException("Error in GetClientById.execute", "Incomplete data");
            }
        } catch (RequestException e) {
            log.error("Error in GetClientById.execute -> "+ e.getMessage());
        }

        response = new AsyncResponse<>(this.clientBusiness.getClientById(request));

        return response;
    }
}
