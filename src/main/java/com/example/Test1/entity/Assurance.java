package com.example.Test1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor

@Entity
@Table(name = "assurance")
@Data
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id ;
    @ManyToOne
    @JoinColumn(name ="insurer_id",nullable = false,referencedColumnName = "id")
    private Insurer insurer;
    @OneToOne
    @JoinColumn(name = "car_id",referencedColumnName = "id")
    private Car car;
    @OneToOne
    @JoinColumn(name = "quote_id",referencedColumnName = "id")
    private Quote quote;




}
