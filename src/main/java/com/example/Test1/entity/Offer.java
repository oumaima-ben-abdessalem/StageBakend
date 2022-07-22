package com.example.Test1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offer")
@Getter
@Setter

public class Offer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "offer")
    @JsonIgnore
    private List<OfferType> offerTypes;
    private int maxAccidents;
    private int minAccidents ;
    private int minAge ;
    private int minCarAge ;
    private int maxPower ;
    private int minPower ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "offer")
    @JsonIgnore
    private List<CarType> carTypes;
    private int mindrivingExp ;



    @ManyToOne
    @JoinColumn(name ="insurer_id",nullable = false,referencedColumnName = "id")
    @JsonIgnore
    private Insurer insurer;



}
