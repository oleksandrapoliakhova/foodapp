package com.foodapp.foodapp.services;

import com.foodapp.foodapp.FoodTagColor;
import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.entity.FoodTag;
import com.foodapp.foodapp.mappers.FoodTagMapper;
import com.foodapp.foodapp.repository.FoodEntryRepo;
import com.foodapp.foodapp.repository.FoodTagRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodTagService {

    private FoodTagMapper foodTagMapper;
    private FoodTagRepo foodTagRepo;

    public FoodTagService(FoodTagMapper foodTagMapper, FoodTagRepo foodTagRepo) {
        this.foodTagMapper = foodTagMapper;
        this.foodTagRepo = foodTagRepo;
    }

    public void saveFoodTag(String foodTagName, FoodTagColor foodTagColor) {

        FoodTagDTO foodTagDTO = new FoodTagDTO();
        foodTagDTO.setFoodTagName(foodTagName);
        foodTagDTO.setFoodTagColor(foodTagColor);

        FoodTag foodTag = foodTagMapper.mapDtoToEntity(foodTagDTO);

        foodTagRepo.save(foodTag);

    }

    public void deleteFoodTag (String foodTagId) {

        foodTagRepo.deleteAllById(foodTagId);
    }

    public List<FoodTagDTO> getFoodTags(String foodEntryId) {

        List<FoodTag> foodTagList = foodTagRepo.findAllById(foodEntryId);

        return foodTagList
                .stream().map(f -> foodTagMapper.mapEntityToDto(f)).collect(Collectors.toList());
    }
}
