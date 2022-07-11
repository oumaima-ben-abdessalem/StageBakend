package com.example.Test1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor

@Entity
@Table(name = "insurer")
@Data
public class Insurer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id ;
    private String emailAddress ;
    private String phoneNumber ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "insurer")
    private List<Assurance> assurances ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "insurer")
    private List<Review> reviews ;

}
