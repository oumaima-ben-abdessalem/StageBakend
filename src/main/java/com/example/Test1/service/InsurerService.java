package com.example.Test1.service;

import com.example.Test1.dao.ClientRepository;
import com.example.Test1.dao.InsurerRepository;
import com.example.Test1.entity.Client;
import com.example.Test1.entity.Insurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InsurerService {
    @Autowired
    private InsurerRepository insurerRepository;


    public InsurerService(InsurerRepository insurerRepository) {
        this.insurerRepository = insurerRepository;
    }

    public Insurer addInsurer(Insurer insurer) {
        return (insurerRepository.save(insurer));
    }

    public List<Insurer> getAllInsurers() {
        return insurerRepository.findAll();
    }

    public Insurer updateInsurer(Insurer insurer) {

        return insurerRepository.save(insurer);
    }

    public void deleteInsurer(Long id) {
        insurerRepository.deleteById(id);

    }
    public Insurer getInsurerById(Long id){

        return(insurerRepository.findById(id).orElse(null));
    }
}
