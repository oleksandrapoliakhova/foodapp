package com.foodapp.foodapp.mappers;

import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.entity.FoodTag;
import org.springframework.stereotype.Component;

@Component
public class FoodTagMapper {

    public FoodTag mapDtoToEntity(FoodTagDTO f) {

        FoodTag foodTag = new FoodTag();
        foodTag.setFoodTagColor(f.getFoodTagColor());
        foodTag.setFoodTagName(f.getFoodTagName());
        foodTag.setActiveInd(f.isActiveInd());

        return foodTag;
    }

    public FoodTagDTO mapEntityToDto(FoodTag f) {

        FoodTagDTO foodTagDTO = new FoodTagDTO();
        foodTagDTO.setFoodTagName(f.getFoodTagName());
        foodTagDTO.setFoodTagColor(f.getFoodTagColor());
        foodTagDTO.setId(f.getId());

        return foodTagDTO;

    }
}
