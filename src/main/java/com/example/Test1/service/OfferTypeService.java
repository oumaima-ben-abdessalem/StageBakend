package com.example.Test1.service;
import com.example.Test1.dao.OfferRepository;
import com.example.Test1.dao.OfferTypeRepository;
import com.example.Test1.entity.Offer;
import com.example.Test1.entity.OfferType;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfferTypeService
{
    private OfferRepository offerRepository;
    private OfferTypeRepository offerTypeRepository;
    public OfferTypeService(OfferRepository offerRepository,OfferTypeRepository offerTypeRepository) {

        this.offerRepository = offerRepository ;
        this.offerTypeRepository = offerTypeRepository;
    }

    public OfferType addOfferType(Long offerId, OfferType offerType) {
        Offer offer = offerRepository.findById(offerId).get();
        offerType.setOffer(offer);
        return (offerTypeRepository.save(offerType));
    }

    public List<OfferType> getAllOfferTypes() {
        return offerTypeRepository.findAll();
    }

    public OfferType updateOfferType(Long id,Long offerId,OfferType offerType)
    {
        Offer oldOffer = offerRepository.findById(offerId).get();
        OfferType oldOfferType  = offerTypeRepository.findById(id).get();
        oldOfferType.setId(id);
        oldOfferType.setGuaranteeName(offerType.getGuaranteeName());
        oldOfferType.setGuaranteePrice(oldOfferType.getGuaranteePrice());
        return offerTypeRepository.save(oldOfferType);
    }

    public void deleteOfferType(Long id) {
        offerTypeRepository.deleteById(id);

    }
    public OfferType getOfferTypeById(Long id){

        return(offerTypeRepository.findById(id).orElse(null));
    }


}
