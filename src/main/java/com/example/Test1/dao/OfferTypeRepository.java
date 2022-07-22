package com.example.Test1.dao;

import com.example.Test1.entity.Offer;
import com.example.Test1.entity.OfferType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferTypeRepository extends JpaRepository<OfferType,Long>
{

}
