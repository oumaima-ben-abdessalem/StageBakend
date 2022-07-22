package com.example.Test1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
@Getter
@Setter


public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Nullable
    private  Long id ;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="clientId",nullable = false,referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name ="carTypeId",nullable = false,referencedColumnName = "id")
    private CarType carType ;
    private int carAge ;
    private int power ;
    private String countryRegistration ;
    private Date registerTimeCar ;



}
