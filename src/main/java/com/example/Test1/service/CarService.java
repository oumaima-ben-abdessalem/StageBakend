package com.example.Test1.service;

import com.example.Test1.dao.CarRepository;
import com.example.Test1.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService
{
    @Autowired
    private CarRepository carRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(Car car) {
        return (carRepository.save(car));
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car updateCar(Car car) {



        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);

    }
    public Car getCarById(Long id){

        return(carRepository.findById(id).orElse(null));
    }



}