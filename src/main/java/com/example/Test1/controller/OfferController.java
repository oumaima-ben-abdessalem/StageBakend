package com.example.Test1.controller;

import com.example.Test1.entity.Car;
import com.example.Test1.entity.Offer;
import com.example.Test1.service.CarService;
import com.example.Test1.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/offer")
@RestController
public class OfferController
{
    @Autowired
    private final OfferService offerService;
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }
    @GetMapping("/offers")
    public ResponseEntity<List<Offer>> getAllOffers() {
        return new ResponseEntity<>(offerService.getAllOffers(), HttpStatus.OK);
    }

    @PostMapping("/add/{insurerName}")
    public ResponseEntity<Offer> addOffer(@PathVariable("nameInsurer") String nameInsurer
            ,@RequestBody Offer offer) {
        Offer newOffer = offerService.addOffer(nameInsurer,offer);
        return new ResponseEntity<>(newOffer, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}/{insurerName}")
    public ResponseEntity<Offer> updateOffer(@PathVariable("id")Long id,
                                         @PathVariable("insurerName")String insurerName,@RequestBody Offer offer) {
        Offer updatedOffer = offerService.updateOffer(id,insurerName,offer);
        return new ResponseEntity<>(updatedOffer,HttpStatus.OK) ;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOffer(@PathVariable("id") Long id ){
        offerService.deleteOffer(id);
        return(new ResponseEntity<>(HttpStatus.OK)) ;
    }

}
