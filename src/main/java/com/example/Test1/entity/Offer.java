package com.example.Test1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Offer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "offer")
    //@JsonIgnore
    private List<OfferType> offerTypes;
    private int maxAccidents;
    private int minAge ;
    private int minCarAge ;
    private int maxPower ;
    private int minPower ;
    @Column(name = "price", nullable = false, columnDefinition = "float default 0.0")
    private Double price = 0.0 ;
    //@OneToMany(cascade = CascadeType.ALL,mappedBy = "offer")
   // @JsonIgnore
    //private List<CarType> carTypes;
    private int minDrivingExp ;
    private boolean favourite = false ;
    @ManyToOne
    @JoinColumn(name ="insurer_id",nullable = false,referencedColumnName = "id")
    //@JsonIgnore
    private Insurer insurer;
    public boolean isFavourite() {
        return favourite;
    }
    public Offer(Long id,boolean favourite,Insurer insurer) {
        this.id = id ;
        this.favourite = favourite ;
        this.insurer = insurer;
    }


}
