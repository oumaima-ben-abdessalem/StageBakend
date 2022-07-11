package com.example.Test1.dao;

import com.example.Test1.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long>
{
    void deleteCarById(Long id);


}