package com.foodapp.foodapp.dto;

import com.foodapp.foodapp.types.FoodTagColor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreationFoodTagDTO {

    private String foodTagName;
    private FoodTagColor foodTagColor;
}
