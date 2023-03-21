package com.foodapp.foodapp.repository;

import com.foodapp.foodapp.entity.FoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodEntryRepo extends JpaRepository<FoodEntry, Integer> {

}
