package com.example.Test1.dao;

import com.example.Test1.entity.Car;
import com.example.Test1.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {



}
