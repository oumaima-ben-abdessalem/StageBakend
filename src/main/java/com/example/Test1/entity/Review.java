package com.example.Test1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor

@Entity
@Table(name = "review")
@Data
public class Review  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    private String content ;
    private int rating ;
    @OneToOne
    @JoinColumn(name = "client_id",referencedColumnName = "id")
    private Client client;
    @ManyToOne
    @JoinColumn(name ="insurer_id",nullable = false,referencedColumnName = "id")
    private Insurer insurer;



}
