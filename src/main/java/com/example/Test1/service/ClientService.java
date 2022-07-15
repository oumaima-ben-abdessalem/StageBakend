package com.example.Test1.service;

import com.example.Test1.dao.CarRepository;
import com.example.Test1.dao.ClientRepository;
import com.example.Test1.entity.Car;
import com.example.Test1.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService
{
    @Autowired
    private ClientRepository clientRepository;


    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(Client client) {
        return (clientRepository.save(client));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client updateClient(Client client) {

        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }
    public Client getClientById(Long id){

        return(clientRepository.findById(id).orElse(null));
    }

}
