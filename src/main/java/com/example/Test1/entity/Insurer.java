package com.example.Test1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String name ;
    private String emailAddress ;
    private String phoneNumber ;
    private String imageUrl ;
    private String address ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "insurer")
    @JsonIgnore
    private List<Offer> offers ;
    //@OneToMany(cascade = CascadeType.ALL,mappedBy = "insurer")
    //private List<Review> reviews ;

}
