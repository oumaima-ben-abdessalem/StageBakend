package com.example.Test1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offerType")
@Getter
@Setter

public class OfferType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id ;
    private String guaranteeName ;
    private double guaranteePrice ;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="offerId",nullable =true,referencedColumnName = "id")
    private Offer offer ;

}
