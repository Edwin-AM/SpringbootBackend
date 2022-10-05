package com.nlxa.java.controller;

import com.nlxa.java.dto.client.request.AddClientRequest;
import com.nlxa.java.dto.client.request.DeleteClientRequest;
import com.nlxa.java.dto.client.request.GetClientByIdRequest;
import com.nlxa.java.dto.client.request.UpdateClientRequest;
import com.nlxa.java.dto.client.response.ClientDeleteResponse;
import com.nlxa.java.dto.client.response.ClientResponse;
import com.nlxa.java.dto.product.request.DeleteProductByIdRequest;
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
    public ResponseEntity<Future<ClientResponse>> addClient(@RequestBody AddClientRequest request) {
        log.info("Call to: ClientController.addClient()");
        Future<ClientResponse> response = null;

        try {
            response = this.addClient.execute(request);
        } catch (IncompleteDataException ie) {
            log.error("Error in: ClientController.addClient() | IncompleteDataException | " + ie.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e){
            log.error("Error in: ClientController.addClient() | IllegalArgumentException | " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (NullPointerException eo) {
            log.error("Error in: ClientController.addClient() | NullPointerException | " + eo.getMessage());
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
     * @return ResponseEntity<Future<ClientResponse>>
     */
    @PutMapping(value = "/update")
    public ResponseEntity<Future<ClientResponse>> updateClient(@RequestBody UpdateClientRequest request) {
        log.info("Call to: ClientController.updateClient()");
        Future<ClientResponse> response = null;

        try {
            response = this.updateClient.execute(request);
        } catch (IncompleteDataException ie) {
            log.error("Error in: ClientController.updateClient() | IncompleteDataException | " + ie.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e){
            log.error("Error in: ClientController.updateClient() | IllegalArgumentException | " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (NullPointerException eo) {
            log.error("Error in: ClientController.updateClient() | NullPointerException | " + eo.getMessage());
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
     * @returnResponseEntity<Future<ClientDeleteResponse>>
     */
    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<Future<ClientDeleteResponse>> deleteById(@RequestBody DeleteClientRequest request) {
        log.info("Call to: ClientController.deleteById()");
        Future<ClientDeleteResponse> response = null;

        try {
            response = this.deleteClientById.execute(request);
        } catch (IncompleteDataException ie) {
            log.error("Error in: ClientController.deleteById() | IncompleteDataException | " + ie.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e){
            log.error("Error in: ClientController.deleteById() | IllegalArgumentException | " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (NullPointerException eo) {
            log.error("Error in: ClientController.deleteById() | NullPointerException | " + eo.getMessage());
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
     * @return ResponseEntity<Future<ClientResponse>>
     */
    @GetMapping(value = "id")
    public ResponseEntity<Future<ClientResponse>> getById(@RequestBody GetClientByIdRequest request) {
        log.info("Call to: ClientController.deleteById()");
        Future<ClientResponse> response = null;

        try {
            response = this.getClientById.execute(request);
        } catch (IncompleteDataException ie) {
            log.error("Error in: ClientController.deleteById() | IncompleteDataException | " + ie.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e){
            log.error("Error in: ClientController.deleteById() | IllegalArgumentException | " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (NullPointerException eo) {
            log.error("Error in: ClientController.deleteById() | NullPointerException | " + eo.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } finally {
            log.info("[+] Request values in ClientController.deleteById: " + request.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
