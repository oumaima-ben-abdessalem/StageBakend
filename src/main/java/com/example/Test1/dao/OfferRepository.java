package com.example.Test1.dao;
import com.example.Test1.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OfferRepository extends JpaRepository<Offer,Long>, CustomOfferRepository
{
    public List<Offer> findByInsurerNameContaining (String name);
}
