package com.example.Test1.controller;
import com.example.Test1.entity.CarType;
import com.example.Test1.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping("/add")
    public ResponseEntity<CarType> addCarType(@RequestBody CarType carType) {
        CarType newCarType = carTypeService.addCarType(carType);
        return new ResponseEntity<>(newCarType, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CarType> updateCarType(@RequestBody CarType carType) {
        CarType updatedCarType = carTypeService.updateCarType(carType);
        return new ResponseEntity<>(updatedCarType,HttpStatus.OK) ;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCarType(@PathVariable("id") Long id ){
        carTypeService.deleteCarType(id);
        return(new ResponseEntity<>(HttpStatus.OK)) ;
    }
    @GetMapping("/getModelsByBrand")
    public ResponseEntity<List<String>> getAllModelsByBrand(String brand) {
        return new ResponseEntity<>(carTypeService.getcarModelsByBrand(brand), HttpStatus.OK);
    }



}
