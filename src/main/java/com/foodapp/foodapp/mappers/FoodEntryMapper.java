package com.foodapp.foodapp.mappers;

import com.foodapp.foodapp.dto.FoodEntryDTO;
import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.entity.FoodEntry;
import com.foodapp.foodapp.entity.FoodTag;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class FoodEntryMapper {

    private FoodTagMapper foodTagMapper;

    public FoodEntryMapper(FoodTagMapper foodTagMapper) {
        this.foodTagMapper = foodTagMapper;
    }

    public FoodEntry mapDtoToEntity(FoodEntryDTO foodEntryDTO) {

        FoodEntry foodEntry = new FoodEntry();
        foodEntry.setFoodEntry(foodEntryDTO.getFoodEntry());
        foodEntry.setUpdatedTime(foodEntryDTO.getLocalDate());
        List<FoodTag> foodTags = foodEntryDTO.getFoodTagList().stream()
                        .filter(Objects::nonNull)
                        .map(f -> foodTagMapper.mapDtoToEntity(f)).collect(Collectors.toList());
        foodEntry.setFoodTagList(foodTags);
        return foodEntry;
    }

    public FoodEntryDTO mapEntityToDTO(FoodEntry f) {

        FoodEntryDTO foodEntryDTO = new FoodEntryDTO();
        foodEntryDTO.setFoodEntry(f.getFoodEntry());
        List<FoodTagDTO> foodEntryDTOS = f.getFoodTagList()
                .stream().map(e -> foodTagMapper.mapEntityToDto(e)).collect(Collectors.toList());
        foodEntryDTO.setFoodTagList(foodEntryDTOS);

        return foodEntryDTO;
    }
}
