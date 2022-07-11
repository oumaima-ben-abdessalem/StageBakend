package com.example.Test1.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@AllArgsConstructor

@Entity
@Table(name = "car")
@Data


public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id ;
    @ManyToOne
    @JoinColumn(name ="client_id",nullable = false,referencedColumnName = "id")
    private Client client;
    //private  String carmanufacturer ;
    private String model ;
    private String brand ;
    private String category ;
    private int carAge ;
    private Date registertimecar ;
    private String countryregistration ;


}
