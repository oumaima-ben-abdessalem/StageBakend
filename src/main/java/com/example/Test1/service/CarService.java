package com.example.Test1.service;
import com.example.Test1.dao.CarRepository;
import com.example.Test1.dao.CarTypeRepository;
import com.example.Test1.dao.ClientRepository;
import com.example.Test1.entity.Car;
import com.example.Test1.entity.CarType;
import com.example.Test1.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService
{
    @Autowired
    private CarRepository carRepository;
    private ClientRepository clientRepository ;
    private CarTypeRepository carTypeRepository ;


    public CarService(CarRepository carRepository, ClientRepository clientRepository, CarTypeRepository carTypeRepository) {

        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
        this.carTypeRepository = carTypeRepository;
    }

    public Car addCar(Long clientId,Long carTypeId,Car car) {
        Client client = clientRepository.findById(clientId).get();
        CarType carType = carTypeRepository.findById(carTypeId).get();
        car.setClient(client);
        car.setCarType(carType);
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