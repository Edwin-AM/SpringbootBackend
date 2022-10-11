package com.nlxa.java.usecase.client;

import com.nlxa.java.client.ClientBusiness;
import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.client.request.DeleteClientRequest;
import com.nlxa.java.dto.client.response.ClientDeleteResponse;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.exceptions.IncompleteDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class DeleteClientById {

    private ClientBusiness clientBusiness;

    @Autowired
    public DeleteClientById(ClientBusiness clientBusiness) {
        this.clientBusiness = clientBusiness;
    }

    /**
     * Tries to delete a client given an id, validating its data
     *
     * @param request DeleteClientRequest
     * @return Future<ClientDeleteResponse>
     * @throws RequestException
     */
    public Future<ClientDeleteResponse> execute(DeleteClientRequest request) throws RequestException {
        log.info("Call to: DeleteClientById.execute()");
        AsyncResponse<ClientDeleteResponse> response = null;

        try {
            if (request.getClientId().equalsIgnoreCase("")) {
                throw new RequestException("Error in DeleteClientById.execute", "Incomplete data");
            }
        } catch (RequestException e) {
            log.error("Error in DeleteClientById.execute -> "+ e.getMessage());
        }

        response = new AsyncResponse<>(this.clientBusiness.deleteClientById(request));
        return response;
    }
}
