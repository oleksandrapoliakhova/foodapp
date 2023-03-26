package com.foodapp.foodapp.repository;

import com.foodapp.foodapp.entity.FoodEntry;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodEntryRepo extends JpaRepository<FoodEntry, Integer> {

    List<FoodEntry> findAllByUserId(Integer userId);

}
