package com.example.Test1.controller;
import com.example.Test1.entity.Insurer;
import com.example.Test1.service.InsurerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("/insurer")
@RestController
public class InsurerController {
    @Autowired
    private final InsurerService insurerService;
    public InsurerController(InsurerService insurerService) {
        this.insurerService = insurerService;
    }
    @GetMapping("/insurers")
    public ResponseEntity<List<Insurer>> getAllInsurers() {
        return new ResponseEntity<>(insurerService.getAllInsurers(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Insurer> addInsurer(@RequestBody Insurer insurer) {
        Insurer newInsurer = insurerService.addInsurer(insurer);
        return new ResponseEntity<>(newInsurer, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Insurer> updateInsurer(@PathVariable("id") Long id,@RequestBody Insurer insurer) {
        Insurer updatedInsurer = insurerService.updateInsurer(id,insurer);
        return new ResponseEntity<>(updatedInsurer,HttpStatus.OK) ;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInsurer(@PathVariable("id") Long id ){
        insurerService.deleteInsurer(id);
        return(new ResponseEntity<>(HttpStatus.OK)) ;
    }
    @GetMapping("/getInsurerNames")
    public ResponseEntity<List<String>> getInsurerNames()
    {
        return new ResponseEntity<>(insurerService.getInsurerNames(), HttpStatus.OK);
    }
    @GetMapping("/getInsurerLogos")
    public ResponseEntity<List<String>> getInsurerLogos()
    {
        return  new ResponseEntity<>(insurerService.getInsurerLogos(),HttpStatus.OK);
    }

}
