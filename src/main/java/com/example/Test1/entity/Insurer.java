package com.example.Test1.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "insurer")
@Getter
@Setter
public class Insurer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id ;
    private String emailAddress ;
    private String phoneNumber ;
    private String imageUrl ;
    //@OneToMany(cascade = CascadeType.ALL,mappedBy = "insurer")
    //private List<Assurance> assurances ;
    //@OneToMany(cascade = CascadeType.ALL,mappedBy = "insurer")
    //private List<Review> reviews ;

}
