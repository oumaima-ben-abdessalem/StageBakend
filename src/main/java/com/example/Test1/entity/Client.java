package com.example.Test1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
