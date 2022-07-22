package com.example.Test1.dao;
import com.example.Test1.entity.CarType;
import com.example.Test1.entity.Insurer;
import com.example.Test1.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long>
{
   // @Query("select o from Offer where o.minAge <= ageClient or numberAccidents between o.maxAccidents" +
          //  " and o.minAccidents or o.mindrivingExp <= drivingexp or cartypeClient in o.carTypes")
   // List<Offer> findpossibleOffers(int ageClient, int numberAccidents, int drivingexp, CarType cartypeClient);
}
