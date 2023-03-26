package com.foodapp.foodapp.mappers;

import com.foodapp.foodapp.dto.FoodEntryDTO;
import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.entity.FoodEntry;
import com.foodapp.foodapp.entity.FoodTag;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class FoodEntryMapper {

    public FoodEntry mapDtoToEntity(FoodEntryDTO foodEntryDTO) {

        FoodEntry foodEntry = new FoodEntry();

        foodEntry.setFoodEntry(foodEntryDTO.getFoodEntry());
        foodEntry.setId(foodEntryDTO.getId());
        foodEntry.setFoodEntryDay(foodEntryDTO.getFoodEntryDate());
        foodEntry.setUpdatedTime(foodEntryDTO.getUpdatedTime());

        return foodEntry;
    }

    public FoodEntryDTO mapEntityToDTO(FoodEntry f) {

        FoodEntryDTO foodEntryDTO = new FoodEntryDTO();

        foodEntryDTO.setFoodEntry(f.getFoodEntry());
        foodEntryDTO.setUpdatedTime(f.getUpdatedTime());
        foodEntryDTO.setFoodEntryDate(f.getFoodEntryDay());
        foodEntryDTO.setId(f.getId());

        return foodEntryDTO;
    }
}
