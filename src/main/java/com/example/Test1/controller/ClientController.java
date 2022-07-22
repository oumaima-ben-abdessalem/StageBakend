package com.example.Test1.controller;
import com.example.Test1.entity.Client;
import com.example.Test1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/client")
@RestController
public class ClientController {
    @Autowired
    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client newClient = clientService.addClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id ,@RequestBody Client client) {
        Client updatedClient = clientService.updateClient(id,client);
        return new ResponseEntity<>(updatedClient,HttpStatus.OK) ;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id ){
        clientService.deleteClient(id);
        return(new ResponseEntity<>(HttpStatus.OK)) ;
    }
}
