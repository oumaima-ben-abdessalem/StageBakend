package com.example.Test1.dao;

import com.example.Test1.entity.Car;
import com.example.Test1.entity.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType,Long> {
    List<CarType> findCarTypesBybrand(String brand);


}
