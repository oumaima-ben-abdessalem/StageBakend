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

    public Client updateClient(Long id,Client client) {
        Client oldClient = clientRepository.findById(id).get();
        oldClient.setBirthDate(client.getBirthDate());
        oldClient.setOldClaims(client.getOldClaims());
        oldClient.setId(id);
        oldClient.setDrivingExperience(client.getDrivingExperience());
        oldClient.setActivePolicy(client.isActivePolicy());
        oldClient.setName(client.getName());
        oldClient.setEmailAddress(client.getEmailAddress());
        oldClient.setPhoneNumber(client.getPhoneNumber());
        oldClient.setCurrentInsurer(client.getCurrentInsurer());
        oldClient.setNumberAccidents(client.getNumberAccidents());


        return clientRepository.save(oldClient);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }
    public Client getClientById(Long id){

        return(clientRepository.findById(id).orElse(null));
    }

}
