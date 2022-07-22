package com.example.Test1.entity;

import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "assurance")
@Getter
@Setter
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id ;
    @OneToOne
    @JoinColumn(name = "car_id",referencedColumnName = "id")
    private Car car;
    @OneToOne
    @JoinColumn(name = "quote_id",referencedColumnName = "id")
    private Quote quote;
    private String description ;




}
