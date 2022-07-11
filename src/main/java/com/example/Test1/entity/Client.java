package com.example.Test1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@AllArgsConstructor

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id ;
    private  String userName ;
    private  String name ;
    private  String password ;
    private  String emailAdress ;
    private Date birthDate ;
    private Role role;
    private String phoneNumber ;
    private int drivingExperience ;
    private boolean activePolicy ;
    private  String currentInsurer ;
    private boolean oldClaims ;
    private  int numberAccidents ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private List<Car> cars;


}
