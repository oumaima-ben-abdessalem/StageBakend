package com.example.Test1.service;

import com.example.Test1.dao.ClientRepository;
import com.example.Test1.dao.InsurerRepository;
import com.example.Test1.entity.CarType;
import com.example.Test1.entity.Client;
import com.example.Test1.entity.Insurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class InsurerService {
    @Autowired
    private InsurerRepository insurerRepository;


    public InsurerService(InsurerRepository insurerRepository)
    {
        this.insurerRepository = insurerRepository;
    }

    public Insurer addInsurer(Insurer insurer) {
        return (insurerRepository.save(insurer));
    }

    public List<Insurer> getAllInsurers() {
        return insurerRepository.findAll();
    }

    public Insurer updateInsurer(Long id,Insurer insurer) {

        Insurer oldInsurer = insurerRepository.findById(id).get();
        oldInsurer.setEmailAddress(insurer.getEmailAddress());
        oldInsurer.setImageUrl(insurer.getImageUrl());
        oldInsurer.setPhoneNumber(insurer.getPhoneNumber());
        oldInsurer.setName(insurer.getName());
        oldInsurer.setId(id);
        return insurerRepository.save(oldInsurer);
    }

    public void deleteInsurer(Long id) {
        insurerRepository.deleteById(id);

    }
    public Insurer getInsurerById(Long id){

        return(insurerRepository.findById(id).orElse(null));
    }
    public List<String> getInsurerNames()
    {
        List<String> listInsurerNames= new ArrayList<>();
        List<Insurer> list = insurerRepository.findAll();
        for (Insurer insurer: list)
        {
            listInsurerNames.add(insurer.getName());
        }
        return listInsurerNames;
    }
    public List<String> getInsurerLogos()
    {
        List<String> listInsurerLogos = new ArrayList<>();
        List<Insurer> list = insurerRepository.findAll();
        for (Insurer insurer : list)
        {
            listInsurerLogos.add(insurer.getImageUrl());
        }
        return (listInsurerLogos);
    }
}
