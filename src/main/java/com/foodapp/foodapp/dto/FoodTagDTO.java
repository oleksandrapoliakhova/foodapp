package com.foodapp.foodapp.dto;

import com.foodapp.foodapp.FoodTagColor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
public class FoodTagDTO {

    private ObjectId id;
    private String foodTagName;
    private FoodTagColor foodTagColor;
}
