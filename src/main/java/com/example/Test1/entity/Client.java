package com.example.Test1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id ;
    private  String name ;
    private Date birthDate ;
    private String phoneNumber ;
    private  String emailAddress ;
    private  String userName ;
    private  String password ;
    private int drivingExperience ;
    private boolean activePolicy ;
    private  String currentInsurer ;
    private int oldClaims ;
    private  int numberAccidents ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    @JsonIgnore
    private List<Car> cars;


}
