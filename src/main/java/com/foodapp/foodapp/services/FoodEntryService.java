package com.foodapp.foodapp.services;

import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.entity.FoodEntry;
import com.foodapp.foodapp.entity.FoodTag;
import com.foodapp.foodapp.mappers.FoodEntryMapper;
import com.foodapp.foodapp.repository.FoodEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodEntryService {

    private FoodEntryMapper foodEntryMapper;
    private FoodEntryRepo foodEntryRepo;

    public FoodEntryService(FoodEntryMapper foodEntryMapper, FoodEntryRepo foodEntryRepo) {
        this.foodEntryMapper = foodEntryMapper;
        this.foodEntryRepo = foodEntryRepo;
    }

    public void saveFoodEntry(String food, List<FoodTagDTO> foodTagList) {

        FoodEntry foodEntry = foodEntryMapper.mapDtoToEntity(food, foodTagList);
        foodEntryRepo.save(foodEntry);

    }

}
