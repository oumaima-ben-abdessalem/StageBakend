package com.example.Test1.controller;

import com.example.Test1.entity.Car;
import com.example.Test1.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/car")
@RestController
public class CarController
{
    @Autowired
    private final CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @PostMapping("/add/{clientId}")
    public ResponseEntity<Car> addCar(@PathVariable("clientId") Long clientId
                                    ,@RequestBody Car car) {
        Car newCar = carService.addCar(clientId,car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}/{clientId}")
    public ResponseEntity<Car> updateCar(@PathVariable("id")Long id,
                                         @PathVariable("clientId")Long clientId,@RequestBody Car car) {
        Car updatedCar = carService.updateCar(id,clientId,car);
        return new ResponseEntity<>(updatedCar,HttpStatus.OK) ;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Long id ){
        carService.deleteCar(id);
        return(new ResponseEntity<>(HttpStatus.OK)) ;
    }





}
