package com.foodapp.foodapp.mappers;

import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.entity.FoodEntry;
import com.foodapp.foodapp.entity.FoodTag;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodEntryMapper {

    private FoodTagMapper foodTagMapper;

    public FoodEntryMapper(FoodTagMapper foodTagMapper) {
        this.foodTagMapper = foodTagMapper;
    }

    public FoodEntry mapDtoToEntity(String food, List<FoodTagDTO> foodTagList) {

        FoodEntry foodEntry = new FoodEntry();
        foodEntry.setId(ObjectId.get());
        foodEntry.setFoodEntry(food);
        List<FoodTag> foodTags =
                foodTagList.stream().map(f -> foodTagMapper.mapDtoToEntity(f)).collect(Collectors.toList());
        foodEntry.setFoodTagList(foodTags);
        return foodEntry;
    }
}
