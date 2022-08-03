package com.example.Test1.dto;

import com.example.Test1.entity.CarType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {
    private int ageClient;
    private int numberAccidents;
    private int drivingExp;
    //private String model;
    //private String brand;
}
