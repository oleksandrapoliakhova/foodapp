package com.foodapp.foodapp.repository;

import com.foodapp.foodapp.entity.FoodEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodEntryRepo extends MongoRepository<FoodEntry, Long> {

}
