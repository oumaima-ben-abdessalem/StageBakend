package com.example.Test1.controller;

import com.example.Test1.entity.Car;
import com.example.Test1.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api")
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

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car newCar = carService.addCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        Car updatedCar = carService.updateCar(car);
        return new ResponseEntity<>(updatedCar,HttpStatus.OK) ;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Long id ){
        carService.deleteCar(id);
        return(new ResponseEntity<>(HttpStatus.OK)) ;
    }





}
