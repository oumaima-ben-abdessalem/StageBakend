package com.example.Test1.service;

import com.example.Test1.dao.CarRepository;
import com.example.Test1.dao.CarTypeRepository;
import com.example.Test1.entity.Car;
import com.example.Test1.entity.CarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarTypeService {
    @Autowired
    private CarTypeRepository carTypeRepository;


    public CarTypeService(CarTypeRepository carTypeRepository) {
        this.carTypeRepository = carTypeRepository;
    }

    public CarType addCarType(CarType carType) {
        return (carTypeRepository.save(carType));
    }

    public List<CarType> getAllTypeCars() {
        return carTypeRepository.findAll();
    }

    public CarType updateCarType(Long id,CarType carType) {

        CarType oldCarType = carTypeRepository.findById(id).get();
        oldCarType.setBrand(carType.getBrand());
        oldCarType.setModel(carType.getModel());
        oldCarType.setId(id);
        return carTypeRepository.save(oldCarType);
    }

    public void deleteCarType(Long id) {
        carTypeRepository.deleteById(id);

    }
    public CarType getCarTypeById(Long id){

        return(carTypeRepository.findById(id).orElse(null));
    }
    public List<String> getcarModelsByBrand(String brand)
    {
        List<String> listModel= new ArrayList<>();
        List<CarType> list = carTypeRepository.findCarTypesBybrand(brand);
        for (CarType carType: list)
        {
            listModel.add(carType.getModel());
        }
        return listModel;
    }

}
