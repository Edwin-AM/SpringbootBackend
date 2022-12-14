package com.nlxa.java.jpa;

import com.nlxa.java.domain.Client;
import com.nlxa.java.domain.Invoice;
import com.nlxa.java.impl.ClientImpl;
import com.nlxa.java.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ClientJPAComponent implements ClientImpl {

    private ClientRepository clientRepository;

    public ClientJPAComponent(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAll() {
        log.info("ClientJPAComponent.getAll");
        List<Client> clients = null;

        try {
            clients = this.clientRepository.findAll();
        } catch (Exception e) {
            log.error("Error in ClientJPAComponent.getAll " + e.getMessage());
        }

        return clients;
    }

    @Override
    public Client getById(String s) {
        log.info("Call to: ClientJPAComponent.getById()");
        Client client = null;

        try {
            client = this.clientRepository.findById(s).orElse(null);
        } catch (Exception e) {
            log.error("Error in ClientJPAComponent.getById " + e.getMessage());
        }

        return client;
    }

    @Override
    public Client save(Client type) {
        log.info("Call to: ClientJPAComponent.save()");
        Client response = null;

        try {
            response = this.clientRepository.save(type);
        } catch (Exception e){
            log.error("Error in: ClientJPAComponent.save() -> "+ e.getMessage(), e);
        }

        return response;
    }

    @Override
    public Client update(Client type) {
        log.info("Call to: ClientJPAComponent.update()");
        Client response = null;

        try {
            response = this.clientRepository.save(type);
        } catch (Exception e){
            log.error("Error in: ClientJPAComponent.update() -> "+ e.getMessage(), e);
        }

        return response;
    }

    @Override
    public void delete(Client type) {
        log.info("Call to: ClientJPAComponent.delete()");
        try {
            this.clientRepository.delete(type);
        } catch (Exception e){
            log.error("Error in: ClientJPAComponent.delete() -> "+ e.getMessage(), e);
        }
    }

    @Override
    public void deleteById(String s) {
        log.info("Call to: ClientJPAComponent.deleteById()");

        try {
            this.clientRepository.deleteById(s);
        }  catch (Exception e){
            log.error("Error in: ClientJPAComponent.deleteById() -> "+ e.getMessage(), e);
        }
    }

    @Override
    public Boolean verifyValueID(String id) {
        return null;
    }
}
