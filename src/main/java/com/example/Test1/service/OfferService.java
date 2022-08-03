package com.example.Test1.service;

import com.example.Test1.dao.*;
import com.example.Test1.dto.OfferDto;
import com.example.Test1.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfferService {
    private OfferRepository offerRepository;
    private InsurerRepository insurerRepository;
    private ClientRepository clientRepository ;
    public OfferService(OfferRepository offerRepository,InsurerRepository insurerRepository,ClientRepository clientRepository) {

        this.offerRepository = offerRepository ;
        this.insurerRepository = insurerRepository;
        this.clientRepository = clientRepository;

    }

    public Offer addOffer(String insurerName, Offer offer) {
       Insurer insurer = insurerRepository.findByName(insurerName);
       offer.setInsurer(insurer);
       return (offerRepository.save(offer));
    }

    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    public Offer updateOffer(Long id,String insurerName,Offer offer)
    {
        Offer oldOffer = offerRepository.findById(id).get();
        Insurer oldInsurer = insurerRepository.findByName(insurerName);
        oldOffer.setId(id);
        oldOffer.setInsurer(oldInsurer);
        return offerRepository.save(oldOffer);
    }

    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);

    }
    public Offer getOfferById(Long id){

        return(offerRepository.findById(id).orElse(null));
    }

   public List<Offer> possibleOffersService(int ageClient, int drivingExp,int numberAccidents)
    {

        return  offerRepository.findPossibleOffers(ageClient, drivingExp, numberAccidents);
    }



} 
