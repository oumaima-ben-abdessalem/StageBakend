package com.example.Test1.controller;

import com.example.Test1.entity.Offer;
import com.example.Test1.entity.OfferType;
import com.example.Test1.service.OfferService;
import com.example.Test1.service.OfferTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/offerType")
@RestController
public class OfferTypeController
{
    @Autowired
    private final OfferTypeService offerTypeService;
    public OfferTypeController(OfferTypeService offerTypeService) {
        this.offerTypeService = offerTypeService;
    }
    @GetMapping("/offerTypes")
    public ResponseEntity<List<OfferType>> getAllOfferTypes() {
        return new ResponseEntity<>(offerTypeService.getAllOfferTypes(), HttpStatus.OK);
    }

    @PostMapping("/add/{offerId}")
    public ResponseEntity<OfferType> addOfferType(@PathVariable("offerId") Long offerId
            ,@RequestBody OfferType offerType) {
        OfferType newOfferType = offerTypeService.addOfferType(offerId,offerType);
        return new ResponseEntity<>(newOfferType, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}/{offerId}")
    public ResponseEntity<OfferType> updateOfferType(@PathVariable("id")Long id,
                                             @PathVariable("offerId")Long offerId,@RequestBody OfferType offerType) {
        OfferType updatedOfferType = offerTypeService.updateOfferType(id,offerId,offerType);
        return new ResponseEntity<>(updatedOfferType,HttpStatus.OK) ;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOfferType(@PathVariable("id") Long id ){
        offerTypeService.deleteOfferType(id);
        return(new ResponseEntity<>(HttpStatus.OK)) ;
    }

}
