package com.example.Test1.entity;

import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review")
@Getter
@Setter
public class Review  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    private String content ;
    private int rating ;
    //@OneToOne
    //@JoinColumn(name = "client_id",referencedColumnName = "id")
    //private Client client;
    //@ManyToOne
    //@JoinColumn(name ="insurer_id",nullable = false,referencedColumnName = "id")
    //private Insurer insurer;



}
