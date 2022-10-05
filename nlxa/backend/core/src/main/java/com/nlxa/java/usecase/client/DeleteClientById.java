package com.nlxa.java.usecase.client;

import com.nlxa.java.client.ClientBusiness;
import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.client.request.DeleteClientRequest;
import com.nlxa.java.dto.client.response.ClientDeleteResponse;
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
     * @throws IncompleteDataException
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    public Future<ClientDeleteResponse> execute(DeleteClientRequest request) throws IncompleteDataException,
            IllegalArgumentException, NullPointerException {
        log.info("Call to: DeleteClientById.execute()");
        AsyncResponse<ClientDeleteResponse> response = null;

        if (request == null) {
            throw new IllegalArgumentException("Null parameter in -> DeleteClientById.execute()");
        }

        if (request.getClientId().equalsIgnoreCase("")) {
            throw new IncompleteDataException("Missing data -> In DeleteClientById.execute()");
        }

        response = new AsyncResponse<>(this.clientBusiness.deleteClientById(request));
        return response;
    }
}
