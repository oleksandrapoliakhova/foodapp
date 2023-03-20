package com.foodapp.foodapp.repository;

import com.foodapp.foodapp.entity.FoodTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodTagRepo extends JpaRepository<FoodTag, Integer> {

    FoodTag findById (String foodTagId);

    void deleteAllById (String id);

}
