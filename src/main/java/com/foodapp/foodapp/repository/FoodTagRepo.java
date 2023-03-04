package com.foodapp.foodapp.repository;

import com.foodapp.foodapp.entity.FoodTag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodTagRepo extends MongoRepository<FoodTag, Long> {

    List<FoodTag> findAllById (String id);

    void deleteAllById (String id);

}
