package com.nlxa.java.controller;

import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.request.DeleteClientRequest;
import com.nlxa.java.dto.client.request.GetClientByIdRequest;
import com.nlxa.java.dto.client.request.UpdateClientRequest;
import com.nlxa.java.dto.client.response.ClientDeleteResponse;
import com.nlxa.java.dto.client.response.ClientResponse;
import com.nlxa.java.dto.product.request.DeleteProductByIdRequest;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.exceptions.IncompleteDataException;
import com.nlxa.java.usecase.client.AddClient;
import com.nlxa.java.usecase.client.DeleteClientById;
import com.nlxa.java.usecase.client.GetClientById;
import com.nlxa.java.usecase.client.UpdateClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@RestController
@RequestMapping(value = "/client")
public class ClientController {

    private AddClient addClient;
    private UpdateClient updateClient;
    private DeleteClientById deleteClientById;
    private GetClientById getClientById;

    @Autowired
    public ClientController(AddClient addClient,
                            UpdateClient updateClient,
                            DeleteClientById deleteClientById,
                            GetClientById getClientById) {
        this.addClient = addClient;
        this.updateClient = updateClient;
        this.deleteClientById = deleteClientById;
        this.getClientById = getClientById;
    }

    /**
     * Insert a new client
     *
     * @param request AddClientRequest
     * @return ResponseEntity<Future<ClientResponse>>
     */
    @PostMapping(value = "/add")
    public ResponseEntity<ClientResponse> addClient(@RequestBody AddClientRequest request) {
        log.info("Call to: ClientController.addClient()");
        Future<ClientResponse> result = null;
        ClientResponse response = null;
        try {
            result = this.addClient.execute(request);
            response = result.get();
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (RequestException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } finally {
            log.info("[+] Request values in ClientController.addClient: " + request.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Update a client
     *
     * @param request UpdateClientRequest
     * @return ResponseEntity<ClientResponse>
     */
    @PutMapping(value = "/update")
    public ResponseEntity<ClientResponse> updateClient(@RequestBody UpdateClientRequest request) {
        log.info("Call to: ClientController.updateClient()");
        Future<ClientResponse> result = null;
        ClientResponse response = null;
        try {
            result = this.updateClient.execute(request);
            response = result.get();
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (RequestException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } finally {
            log.info("[+] Request values in ClientController.updateClient: " + request.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Delete a client given an id
     *
     * @param request DeleteClientRequest
     * @return ResponseEntity<ClientDeleteResponse>
     */
    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<ClientDeleteResponse> deleteById(@RequestBody DeleteClientRequest request) {
        log.info("Call to: ClientController.deleteById()");
        Future<ClientDeleteResponse> result = null;
        ClientDeleteResponse response = null;
        try {
            result = this.deleteClientById.execute(request);
            response = result.get();
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (RequestException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } finally {
            log.info("[+] Request values in ClientController.deleteById: " + request.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Get a client given an id
     *
     * @param request GetClientByIdRequest
     * @return ResponseEntity<ClientResponse>
     */
    @GetMapping(value = "id")
    public ResponseEntity<ClientResponse> getById(@RequestBody GetClientByIdRequest request) {
        log.info("Call to: ClientController.getById()");
        Future<ClientResponse> result = null;
        ClientResponse response = null;
        try {
            result = this.getClientById.execute(request);
            response = result.get();
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (RequestException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } finally {
            log.info("[+] Request values in ClientController.getById: " + request.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
