package com.example.Test1.dao.implementation;

import com.example.Test1.dao.CarTypeRepository;
import com.example.Test1.dao.CustomOfferRepository;
import com.example.Test1.dto.OfferDto;
import com.example.Test1.entity.CarType;
import com.example.Test1.entity.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomOfferRepositoryImpl implements CustomOfferRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    CarTypeRepository carTypeRepository;
    @Override
   // @Query("select o from Offer where o.minAge <= offerDto.ageClient or numberAccidents between o.maxAccidents and o.minAccidents or o.mindrivingExp <= drivingexp or cartypeClient in o.carTypes")
    public List<Offer> findPossibleOffers(int ageClient, int drivingExp,int numberAccidents  ) {
        //CarType carType = carTypeRepository.findByBrandAndModel(offerDto.getBrand(), offerDto.getModel());
        Query query = entityManager.createNativeQuery("SELECT * FROM `offer` where min_age <=:ageClient and min_driving_exp <=:drivingExp and max_accidents >=:numberAccidents", Offer.class);
        query.setParameter("ageClient",ageClient);
        //query.setParameter("carType", carType );
        query.setParameter("drivingExp",drivingExp);
        query.setParameter("numberAccidents",numberAccidents);


        return query.getResultList();
    }
    @Override

    public List<Offer> search2(String name,int ageClient, int drivingExp,int numberAccidents  ) {
        Query query = entityManager.createNativeQuery("SELECT * FROM `offer` o  join `insurer` i on o.insurer_id =:i.id where min_age <=:ageClient and min_driving_exp <=:drivingExp and max_accidents >=:numberAccidents and i.name LIKE '%m%' ", Offer.class);
        query.setParameter("ageClient",ageClient);
        query.setParameter("name", name );
        query.setParameter("drivingExp",drivingExp);
        query.setParameter("numberAccidents",numberAccidents);


        return query.getResultList();
    }
}
