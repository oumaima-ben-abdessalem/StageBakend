package com.example.Test1.controller;
import com.example.Test1.entity.CarType;
import com.example.Test1.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("/carType")
@RestController
public class CarTypeController {
    @Autowired
    private final CarTypeService carTypeService;
    public CarTypeController(CarTypeService carTypeService) {
        this.carTypeService = carTypeService;
    }
    @GetMapping("/carsType")
    public ResponseEntity<List<CarType>> getAllTypeCars() {
        return new ResponseEntity<>(carTypeService.getAllTypeCars(), HttpStatus.OK);
    }

    @PostMapping("/add/{offerId}")
    public ResponseEntity<CarType> addCarType(@PathVariable("offerId") long offerId,@RequestBody CarType carType) {
        CarType newCarType = carTypeService.addCarType(offerId,carType);
        return new ResponseEntity<>(newCarType, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CarType> updateCarType(@PathVariable("id") Long id ,@RequestBody CarType carType) {
        CarType updatedCarType = carTypeService.updateCarType(id,carType);
        return new ResponseEntity<>(updatedCarType,HttpStatus.OK) ;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCarType(@PathVariable("id") Long id ){
        carTypeService.deleteCarType(id);
        return(new ResponseEntity<>(HttpStatus.OK)) ;
    }
    @GetMapping("/getModelsByBrand/{brand}")
    public ResponseEntity<List<String>> getAllModelsByBrand(@PathVariable("brand") String brand) {
        return new ResponseEntity<>(carTypeService.getcarModelsByBrand(brand), HttpStatus.OK);
    }
    @GetMapping("/getBrands")
    public ResponseEntity<Set<String>> getDistinctBrands()
    {
        return new ResponseEntity<>(carTypeService.getDistinctBrands(), HttpStatus.OK);
    }




}
