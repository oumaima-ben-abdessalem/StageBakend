package com.example.Test1.dao;

import com.example.Test1.entity.Client;
import com.example.Test1.entity.Insurer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurerRepository extends JpaRepository<Insurer,Long>
{
    Insurer findByName(String name) ;

}
