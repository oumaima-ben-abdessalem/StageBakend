package com.example.Test1.dao;

import com.example.Test1.dto.OfferDto;
import com.example.Test1.entity.Offer;

import java.util.List;

public interface CustomOfferRepository {
    List<Offer> findPossibleOffers(int ageClient, int drivingExp,int numberAccidents);
    List<Offer> search2(String name,int ageClient, int drivingExp,int numberAccidents);
}
