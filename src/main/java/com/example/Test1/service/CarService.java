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

    public Car addCar(Long clientId,Car car) {
        Client client = clientRepository.findById(clientId).get();
        CarType carType = carTypeRepository.findByBrandAndModel(car.getCarType().getBrand(), car.getCarType().getModel());
        car.setClient(client);
        car.setCarType(carType);
        return (carRepository.save(car));
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car updateCar(Long id,Long clientId,Car car) {

        Car oldCar = carRepository.findById(id).get();
        Client oldClient = clientRepository.findById(clientId).get();
        //CarType oldCarType = carTypeRepository.findById(carTypeId).get();
        //oldCar.setCarType(oldCarType);
        CarType oldCarType = carTypeRepository.findByBrandAndModel(oldCar.getCarType().getBrand(), oldCar.getCarType().getModel());
        oldCarType.setBrand(car.getCarType().getBrand());
        oldCarType.setModel(car.getCarType().getModel());
        oldCar.setClient(oldClient);
        oldCar.setId(id);
        oldCar.setCarAge(car.getCarAge());
        oldCar.setCountryRegistration(car.getCountryRegistration());
        oldCar.setRegisterTimeCar(car.getRegisterTimeCar());
        oldCar.setPower(car.getPower());
        return carRepository.save(oldCar);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);

    }
    public Car getCarById(Long id){

        return(carRepository.findById(id).orElse(null));
    }



}