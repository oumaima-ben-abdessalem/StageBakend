package com.example.Test1.controller;

import com.example.Test1.dto.OfferDto;
import com.example.Test1.entity.Car;
import com.example.Test1.entity.Client;
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
    public ResponseEntity<Offer> addOffer(@PathVariable("insurerName") String nameInsurer
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
    @GetMapping("/findOffers/{ageClient}/{drivingExp}/{numberAccidents}")
    public ResponseEntity<?> findOffer(@PathVariable("ageClient") int ageClient,
                                       @PathVariable("drivingExp") int drivingExp,
                                       @PathVariable("numberAccidents") int numberAccidents){
        return(new ResponseEntity<>(offerService.possibleOffersService(ageClient,drivingExp, numberAccidents), HttpStatus.OK)) ;
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searching (@PathVariable("name") String name){
      return (new ResponseEntity<>(offerService.search(name),HttpStatus.OK));
    }
    @GetMapping("/search2/{name}/{ageClient}/{drivingExp}/{numberAccidents}")
    public ResponseEntity<?> searching2(@PathVariable("name") String name,@PathVariable("ageClient") int ageClient,
                                       @PathVariable("drivingExp") int drivingExp,
                                       @PathVariable("numberAccidents") int numberAccidents){
        return(new ResponseEntity<>(offerService.search2(name,ageClient,drivingExp, numberAccidents), HttpStatus.OK)) ;
    }

    @PutMapping("updatePrice/{id}/{ageClient}/{drivingExp}/{numberAccidents}")
    public ResponseEntity<Offer> updatePrice (@PathVariable("id") Long id,@PathVariable("ageClient") int ageClient,
                                               @PathVariable("drivingExp") int drivingExp,
                                               @PathVariable("numberAccidents") int numberAccidents)
    {
        Offer updatedOffer = offerService.predictOfferPrice(id,ageClient,drivingExp,numberAccidents);
        return  new ResponseEntity<>(updatedOffer,HttpStatus.OK);

    }

    @PutMapping("/favoris/{id}")
    public ResponseEntity<Offer> favourite(@PathVariable("id") Long id) {
        Offer offer  = offerService.findOfferById(id);
        Offer offerUpdated = new Offer(offer.getId(), !offer.isFavourite(),offer.getInsurer());
        this.offerService.addOffer2(offerUpdated);

        return new ResponseEntity<>(offerUpdated, HttpStatus.OK);

    }
    @PutMapping("/findOffer/{id}")
    public ResponseEntity<Offer> find(@PathVariable("id") Long id)
    {
        Offer offer = offerService.findOfferById(id);
        return new ResponseEntity<>(offer, HttpStatus.OK);


    }



}
