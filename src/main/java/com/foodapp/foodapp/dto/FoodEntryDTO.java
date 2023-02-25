package com.foodapp.foodapp.dto;

import com.foodapp.foodapp.entity.FoodTag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FoodEntryDTO {

    private ObjectId id;

    private String foodEntry;

    private List<FoodTag> foodTagList;

}
