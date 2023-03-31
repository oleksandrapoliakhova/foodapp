package com.foodapp.foodapp.repository;

import com.foodapp.foodapp.entity.FoodTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodTagRepo extends JpaRepository<FoodTag, Integer> {

    List<FoodTag> findAllByUserId (Integer id);

}
