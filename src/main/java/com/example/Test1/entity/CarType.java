package com.example.Test1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carType")
@Getter
@Setter
public class CarType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id ;
    private String brand ;
    private String model ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "carType")
    @JsonIgnore
    private List<Car> cars;
    @ManyToOne
    @JoinColumn(name ="offer_id",nullable = true,referencedColumnName = "id")
    @JsonIgnore
    private Offer offer;

}
