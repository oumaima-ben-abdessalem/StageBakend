package com.example.Test1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "client")
@Getter
@Setter
public class Client {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private  Long id ;
    private  String name ;
    private ZonedDateTime birthDate ;
    private String phoneNumber ;
    private  String emailAddress ;
    private int drivingExperience ;
    private boolean activePolicy ;
    private  String currentInsurer ;
    private int oldClaims ;
    private  int numberAccidents ;
    private int age;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    @JsonIgnore
    private List<Car> cars;


}
