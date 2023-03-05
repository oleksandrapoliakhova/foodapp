package com.foodapp.foodapp.repository;

import com.foodapp.foodapp.entity.FoodTag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodTagRepo extends MongoRepository<FoodTag, Long> {

    FoodTag findById (String foodTagId);

    void deleteAllById (String id);

}
